/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.client;

import M0.*;

/**
 *
 * @author Audrey
 */
public class Client extends Composant{
    
    private Port sendRequest;
    public Client(Propriete visualisation, Propriete codeSource, Propriete performance, Port sendRequest, String nom){
        super(nom);
        this.getLstProprietes().add(visualisation);
        this.getLstProprietes().add(codeSource);
        this.getLstProprietes().add(performance);
        this.sendRequest = sendRequest;
        this.getLstSorties().add(this.sendRequest);
    }

    public Port getSendRequest() {
        return sendRequest;
    }

    public void setSendRequest(Port sendRequest) {
        this.sendRequest = sendRequest;
    }
    
    
    
    public Reponse EnvoyerUneRequete(Message message){
        this.setMessage(message);
        return this.getReponse();
    }


    
}
