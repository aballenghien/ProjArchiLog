/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.client.Client;
import M0.serveur.Serveur;

/**
 *
 * @author Audrey, Bertrand
 */
public class SystemCS extends Composant{
    static SystemCS systemCS = null;
    private Client client;
    private Serveur serveur;
    
    
    public SystemCS (Client unClient, Serveur unServeur){
        this.client=unClient;
        this.serveur=unServeur;
        this.lstComposants.add(client);
        this.lstComposants.add(serveur);
    }


    public void initConfiguration(){
        this.client.setConfiguration(this);
        this.serveur.setConfiguration(this);
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

    public Composant getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Composant configuration) {
        this.configuration = configuration;
    }
    
    
    
    
    
}
