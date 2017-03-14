/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.client.Client;
import M0.serveur.ConnectionManager;
import M0.serveur.SecurityManagerProjet;
import M0.serveur.Serveur;

/**
 *
 * @author Audrey, Bertrand
 */
public class SystemCS extends Configuration implements Observateur{
    static SystemCS systemCS = null;
    private Client client;
    private Serveur serveur;
    
    
    public SystemCS (Client unClient, Serveur unServeur, String nom){
        super(nom);
        this.client=unClient;
        this.serveur=unServeur;
        this.getLstElementsArchitecturaux().add(client);
        this.getLstElementsArchitecturaux().add(serveur);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    @Override
    
    //faire authetification avant de faire requête dans la base de données
    // à chaque fois remonter les informations par la configuration
    public void actualiser(Observable o) {
        if(o instanceof Client){
            Client cl = (Client) o;
            Message message  = cl.getMessage();
            cl.getSendRequest().getAttch().getRole().getConnect().transmettreMessage(message);
        }
        if(o instanceof Connecteur){
            Connecteur connect = (Connecteur) o;
            if(connect.getReponse() == null){
                connect.getSortie().getAttch().getPort().getCompo().setMessage(connect.getMessage());
            }else{
                connect.getEntree().getAttch().getPort().getCompo().setReponse(connect.getReponse());
            }
        }
        
        if(o instanceof Serveur){
            Serveur serv = (Serveur) o;
            Reponse resp = serv.getReponse();
            Message mess = serv.getMessage();
            if(resp == null){
                ConnectionManager cm = (ConnectionManager)serv.getInternalServeur().getBind().getSortie().getCompo();
                boolean ok = cm.analyserMessage(mess); 
                
            }else{
                serv.getReceiveRequest().getAttch().getRole().getConnect().setReponse(resp);
            }
        }
        
        if(o instanceof ConnectionManager){
            ConnectionManager cm = (ConnectionManager)o;
            if(cm.getMessage().isAuthentifie()){
                if(cm.getReponse().getColonneValeur().length == 0){
                    cm.getDbQuery().getAttch().getRole().getConnect().setMessage(cm.getMessage());
                }else{
                    cm.getExternalSocket().getBind().getEntree().getCompo().setReponse(cm.getReponse());
                }
            }else{
                cm.getSecurityCheck().getAttch().getRole().getConnect().setMessage(getMessage());
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
                    security.getcQuery().getAttch().getRole().getConnect().setMessage(messageAuthentification);
                }else{
                    if(resp.getColonneValeur()[0][0].equals(messageRecu.getMdp())){
                        messageRecu.setAuthentifie(true);
                        security.getSecurityAut().getAttch().getRole().getConnect().setMessage(messageRecu);
                        Reponse rep = new Reponse(messageRecu.getUser(), messageRecu.getMdp(), messageRecu.getRequete());
                        rep.setAuthentifie(true);
                        security.getSecurityAut().getAttch().getRole().getConnect().setReponse(rep);
                    }else{
                        System.out.println("Erreur lors de l'authentification");
                    }
                }
            }else{
                System.out.println("L'authentification a déjà été faite pour cette requête");
            }
        }
    }
        
    


    
    
    
    
    
}
