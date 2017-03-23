/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.communication.*;
import M0.client.Client;
import M0.serveur.*;
import java.util.ArrayList;

/**
 * Le Système lstClients/serveur est une configuration particulière composée d'un lstClients et d'un serveur relié par un connecteur RPC
 * @author Audrey, Bertrand
 */
public class SystemCS extends Configuration implements Observateur{
    private ArrayList<Client> lstClients;
    private Serveur serveur;
    private Connecteur RPC;
    
    
    /**
     * 
     * @param unServeur (Serveur)
     * @param nom (String)
     * @param rpc (Connecteur)
     */
    public SystemCS (Serveur unServeur, String nom, Connecteur rpc){
        super(nom);
        this.serveur=unServeur;
        this.RPC = rpc;
        this.lstClients = new ArrayList<>();
        this.getLstElementsArchitecturaux().add(this.RPC);
        this.getLstElementsArchitecturaux().add(this.serveur);
    }

    /**
     * 
     * @return lstClients (Client)
     */
    public ArrayList<Client> getLstClients() {
        return lstClients;
    }

    
    public Client getClientByNom(String nom){
        for(Client cl : this.lstClients){
            if(cl.getNom().equals(nom)){
                return cl;
            }
        }
        return this.lstClients.get(0);
    }
    /**
     * 
     * @param client (Client)
     */
    public void addClient(Client client) {
        this.lstClients.add(client);
    }

    /**
     * 
     * @return serveur (Serveur)
     */
    public Serveur getServeur() {
        return serveur;
    }

    /**
     * 
     * @param serveur (Serveur)
     */
    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
    }

    public Connecteur getRPC() {
        return RPC;
    }

    public void setRPC(Connecteur RPC) {
        this.RPC = RPC;
    }
    
    

    /**
     * action réalisée lorsque l'observateur est notifier
     * il transmet le message à l'élement architectural suivant en fonction des sorties et du type de message 
     * @param o (Observable)
     */
    @Override
    public void actualiser(Observable o) {
        
        /**
         * L'observable qui a notifier le System CS est le client:
         * Il souhaite envoyer un message, 
         * si la réponse est renseignée, c'est que le client a déjà eu la réponse
         * il n'est pas nécessaire de transmettre le message         * 
         * Sinon
         * Le message est transmis au connecteur qui est rattaché au client
         * 
         */
        if(o instanceof Client){
            Client cl = (Client) o;
            Message mes = cl.getMessage();
            Reponse resp = cl.getReponse();
            if(resp == null){
                cl.getSendRequest().getAttch().getRole().getConnect().setMessage(mes);
                cl.getSendRequest().getAttch().getRole().getConnect().notififerObservateur();
            }
        }
        
        /**
         * L'observable qui a notifier le SystemCS est le connecteur
         * Si la réponse est renseignée on transmet la réponse au composant qui a envoyé le message, c'est à dire celui rattaché au port "entree"
         * Sinon, on transmet de le message au composant qui doit traité le message, c'est à dire celui relié au port "sortie"
         */
        if(o instanceof Connecteur){
            Connecteur connect = (Connecteur) o;
            Reponse resp = connect.getReponse();
            Message mess = connect.getMessage();
            if(resp == null){
                connect.getSortie().getLstAttch().get(0).getPort().getCompo().setMessage(mess);
            }else{
                connect.getEntree().getAttachByNom(resp.getClient().getSendRequest().getAttch().getNom()).getPort().getCompo().setReponse(resp);
            }
        }
        
        /**
         * L'observable qui a notifier le SystemCs est le serveur
         * Le serveur est lui même une configuration, 
         * si la réponse est renseigné il la transmet au connecteur RPC
         * Sinon, il doit envoyer le message à ses composants internes
         */
        if(o instanceof Serveur){
            Serveur serv = (Serveur) o;
            Reponse resp = serv.getReponse();
            Message mess = serv.getMessage();
            if(resp == null){
                ConnectionManager cm = (ConnectionManager)serv.getInternalServeur().getBind().getSortie().getCompo();
                boolean ok = cm.analyserMessage(mess); 
                
            }else{
                serv.getReceiveRequest().getAttch().getRole().getConnect().setReponse(resp);
                serv.getReceiveRequest().getAttch().getRole().getConnect().notififerObservateur();
            }
        }
    }
        
    


    
    
    
    
    
}
