/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.*;
import M0.communication.*;
import java.util.ArrayList;

/**
 * Le serveur est une configuration particulière, il est supervisé par la configuration SystemCS
 * Il supervise plusieurs éléments architecturaux:
 * - ConnectionManager
 * - SecurityManager
 * - Database
 * 
 * Il communique grâce à deux port:
 * - internalServeur : ainsi il peut envoyer des messages au ConnectionManager
 * - receiveRequest : par lequel il reçoit le message du client et peut émettre la réponse
 * @author Audrey, Bertrand
 */
public class Serveur extends Configuration{
    
    private ConnectionManager connectionManager;
    private SecurityManagerProjet securityManager;
    private Database database;
    private Port receiveRequest;
    private Port internalServeur;
    

    /**
     * 
     * @param connectionManager (ConnectionManager)
     * @param securityManager (SecurityManagerProjet)
     * @param database (Database)
     * @param receiveRequest (Port)
     * @param internalServeur (Port)
     * @param nom (String)
     */
    public Serveur(ConnectionManager connectionManager, SecurityManagerProjet securityManager, Database database, Port receiveRequest, Port internalServeur, String nom) {
        super(nom);
        this.connectionManager = connectionManager;
        this.securityManager = securityManager;
        this.database = database;
        this.getLstElementsArchitecturaux().add (this.connectionManager);
        this.getLstElementsArchitecturaux().add (this.securityManager);
        this.getLstElementsArchitecturaux().add (this.database);
        this.receiveRequest = receiveRequest;
        this.internalServeur = internalServeur;
        this.getLstSorties().add(this.receiveRequest);
        this.getLstSorties().add(this.internalServeur);
    }   

    /**
     * 
     * @return connectionManager (ConnectionManager) 
     */
    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    /**
     * 
     * @param connectionManager (ConnectionManager) 
     */
    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public SecurityManagerProjet getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManagerProjet securityManager) {
        this.securityManager = securityManager;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Port getReceiveRequest() {
        return receiveRequest;
    }

    public void setReceiveRequest(Port receiveRequest) {
        this.receiveRequest = receiveRequest;
    }

    public Port getInternalServeur() {
        return internalServeur;
    }

    public void setInternalServeur(Port internalServeur) {
        this.internalServeur = internalServeur;
    }

    
    /**
     * appeler à chaque fois que la configuration est notifier
     * @param o (Observable)
     */
    @Override
    public void actualiser(Observable o) {
        
        /**
         * La connection manager permet d'authentifier le message puis de l'envoyer à la base de données afin que celle-ci trouve la réponse à la requête
         */
        if(o instanceof ConnectionManager){
            ConnectionManager cm = (ConnectionManager)o;
            if(cm.getMessage().isAuthentifie()){
                if(cm.getReponse().getColonneValeur().length == 0){
                    cm.getDbQuery().getAttch().getRole().getConnect().setMessage(cm.getMessage());
                    cm.getDbQuery().getAttch().getRole().getConnect().notififerObservateur();
                }else{
                    cm.getExternalSocket().getBind().getEntree().getCompo().setReponse(cm.getReponse());
                }
            }else{
                cm.getSecurityCheck().getAttch().getRole().getConnect().setMessage(getMessage());
                cm.getSecurityCheck().getAttch().getRole().getConnect().notififerObservateur();
            }
        }
        
        /**
         * Il authentifie le message en communiquant avec la base de données
         */
        if(o instanceof SecurityManagerProjet){
            SecurityManagerProjet security = (SecurityManagerProjet) o;
            Message messageRecu = security.getMessage();
            Reponse resp = security.getReponse();
            if(!messageRecu.isAuthentifie()){
                if(security.getReponse() == null){
                    Requete req = new Requete();
                    req.setTable("user");
                    req.addColonne("mdp");
                    req.addCondition("nom="+messageRecu.getUser());
                    Message messageAuthentification = new Message("root", "root", req,null);
                    messageAuthentification.setAuthentifie(true);
                    security.getcQuery().getAttch().getRole().getConnect().setMessage(messageAuthentification);
                    security.getcQuery().getAttch().getRole().getConnect().notififerObservateur();
                }else{
                    if(resp.getColonneValeur()[0][0].equals(messageRecu.getMdp())){
                        messageRecu.setAuthentifie(true);
                        security.getSecurityAut().getAttch().getRole().getConnect().setMessage(messageRecu);
                        Reponse rep = new Reponse(messageRecu.getUser(), messageRecu.getMdp(), messageRecu.getRequete(), messageRecu.getClient());
                        rep.setAuthentifie(true);
                        security.getSecurityAut().getAttch().getRole().getConnect().setReponse(rep);
                        security.getSecurityAut().getAttch().getRole().getConnect().notififerObservateur();
                    }else{
                        System.out.println("Erreur lors de l'authentification");
                    }
                }
            }else{
                System.out.println("L'authentification a déjà été faite pour cette requête");
            }
        }
        
        /**
         * Elle recherche les résultats pour un message préalablement authentifier
         */
        if(o instanceof Database){
            Database db = (Database) o;
            Message mess = db.getMessage();
            Reponse resp = db.getReponse();
            if(mess.isAuthentifie()){
                db.repondreRequete();
                if(mess.getUser().equals("root")){
                    db.getSecurityManagement().getAttch().getRole().getConnect().setReponse(database.getReponse());
                    db.getSecurityManagement().getAttch().getRole().getConnect().notififerObservateur();
                }else{
                    db.getQueryInt().getAttch().getRole().getConnect().setReponse(database.getReponse());
                    db.getQueryInt().getAttch().getRole().getConnect().notififerObservateur();
                }
                
            }else{
                System.out.println("Il est nécessaire qu'une authentification ait été effectuée au préalable");
            }
        }
        
        /**
         * Fait le lien entre les différents composant afin de transmettre les messages et les réponses
         */
        if(o instanceof Connecteur){
            Connecteur connect = (Connecteur) o;
            if(connect.getReponse() == null){
                connect.getSortie().getLstAttch().get(0).getPort().getCompo().setMessage(connect.getMessage());
            }else{
                connect.getEntree().getLstAttch().get(0).getPort().getCompo().setReponse(connect.getReponse());
            }
        }
    }


    
}
