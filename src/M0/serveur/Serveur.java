/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Configuration;
import M0.Connecteur;
import M0.ElementArchitectural;
import M0.Message;
import M0.Observable;
import M0.Observateur;
import M0.Port;
import M0.Reponse;
import M0.Requete;
import M0.SystemCS;
import java.util.ArrayList;

/**
 *
 * @author Audrey
 */
public class Serveur extends Configuration{
    
    private ConnectionManager connectionManager;
    private SecurityManagerProjet securityManager;
    private Database database;
    private Port receiveRequest;
    private Port internalServeur;
    

    public Serveur(ConnectionManager connectionManager, SecurityManagerProjet securityManager, Database database, Port receiveRequest, Port internalServeur, String nom) {
        super(nom);
        this.connectionManager = connectionManager;
        this.securityManager = securityManager;
        this.database = database;
        this.setLstElementsArchitecturaux(new ArrayList<ElementArchitectural>());
        this.getLstElementsArchitecturaux().add (this.connectionManager);
        this.getLstElementsArchitecturaux().add (this.securityManager);
        this.getLstElementsArchitecturaux().add (this.database);
        this.receiveRequest = receiveRequest;
        this.internalServeur = internalServeur;
        this.getLstSorties().add(this.receiveRequest);
        this.getLstSorties().add(this.internalServeur);
    }   

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

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

    
    
    @Override
    public void actualiser(Observable o) {
        
        
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
                    Message messageAuthentification = new Message("root", "root", req);
                    messageAuthentification.setAuthentifie(true);
                    security.getcQuery().getAttch().getRole().getConnect().setMessage(messageAuthentification);
                    security.getcQuery().getAttch().getRole().getConnect().notififerObservateur();
                }else{
                    if(resp.getColonneValeur()[0][0].equals(messageRecu.getMdp())){
                        messageRecu.setAuthentifie(true);
                        security.getSecurityAut().getAttch().getRole().getConnect().setMessage(messageRecu);
                        Reponse rep = new Reponse(messageRecu.getUser(), messageRecu.getMdp(), messageRecu.getRequete());
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
        
        if(o instanceof Connecteur){
            Connecteur connect = (Connecteur) o;
            if(connect.getReponse() == null){
                connect.getSortie().getAttch().getPort().getCompo().setMessage(connect.getMessage());
            }else{
                connect.getEntree().getAttch().getPort().getCompo().setReponse(connect.getReponse());
            }
        }
    }


    
}
