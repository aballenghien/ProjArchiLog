/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.client;

import M0.communication.Message;
import M0.communication.Reponse;
import M0.*;

/**
 * Le client est un composant particulier 
 * Il est défini par des propriétés et peut envoyer des message via le port sendRequest
 * @author Audrey, Bertrand
 */
public class Client extends Composant{
    
    private Port sendRequest;
    /**
     * 
     * @param visualisation (Propriete)
     * @param codeSource (Propriete)
     * @param performance (Propriete)
     * @param sendRequest (Port)
     * @param nom  (String)
     */
    public Client(Propriete visualisation, Propriete codeSource, Propriete performance, Port sendRequest, String nom){
        super(nom);
        this.getLstProprietes().add(visualisation);
        this.getLstProprietes().add(codeSource);
        this.getLstProprietes().add(performance);
        this.sendRequest = sendRequest;
        this.getLstSorties().add(this.sendRequest);
    }

    /**
     * 
     * @return sendRequest(Port)
     */
    public Port getSendRequest() {
        return sendRequest;
    }

    /**
     * 
     * @param sendRequest (Port)
     */
    public void setSendRequest(Port sendRequest) {
        this.sendRequest = sendRequest;
    }
    
    
    /**
     * Le message est mis à jour
     * Si le client fait partie d'un système la configuration en sera informé
     * un composant du system devrait apporter une réponse à cette requête qui est aussitôt retournée
     * @param message (Message)
     * @return reponse (Reponse)
     */
    public Reponse EnvoyerUneRequete(Message message){
        this.setMessage(message);
        return this.getReponse();
    }


    
}
