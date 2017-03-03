/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M2.Configuration;

/**
 *
 * @author Audrey
 */
public class SystemCS extends Composant{
    static SystemCS systemCS = null;
    private Client client;
    private Serveur serveur;
    
    
    public static SystemCS getInstance(){
        if(systemCS == null){
            systemCS = new SystemCS();
        }
        return systemCS;
    }
    
    private SystemCS(){
        super();
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        this.lstComposants.add(client);
    }

    public Serveur getServeur() {
        return serveur;
    }

    public void setServeur(Serveur serveur) {
        this.serveur = serveur;
        this.lstComposants.add(serveur);
    }

    public Composant getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Composant configuration) {
        this.configuration = configuration;
    }
    
    
    
    
    
}
