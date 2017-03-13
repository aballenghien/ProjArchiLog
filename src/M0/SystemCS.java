/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.client.Client;
import M0.serveur.ConnectionManager;
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
//                if(cm.authentifier()){
//                    cm.requeteBDD(mess);
//                }
                
            }else{
                serv.getReceiveRequest().getAttch().getRole().getConnect().setReponse(resp);
            }
        }
        
        if(o instanceof ConnectionManager){
            
        }
        
    }


    
    
    
    
    
}
