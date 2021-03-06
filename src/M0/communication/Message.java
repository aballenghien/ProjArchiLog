/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.communication;

import M0.Composant;
import M0.Configuration;
import M0.ElementArchitectural;
import M0.client.Client;

/**
 * Merssage qui transite dans le système
 * il est composé d'un nom et mot de passe permettant d'authentifier l'utilisateur
 * il est également composé d'une requête
 * C'est le message qui est authentifié pour pouvoir accéder à certaine partie du système comme la bdd
 * @author Audrey, bertrand
 */
public class Message {
    private String user;
    private String mdp;
    private Requete requete;
    private boolean authentifie;
    private Client client;

    /**
     * 
     * @param user (String)
     * @param mdp (String)
     * @param requete (Requete)
     */
    public Message(String user, String mdp, Requete requete, Client client) {
        this.user = user;
        this.mdp = mdp;
        this.requete = requete;
        this.client = client;
    }

    /**
     * 
     * @return user(String)
     */
    public String getUser() {
        return user;
    }

    /**
     * 
     * @param user (String)
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * 
     * @return mdp (String)
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * 
     * @param mdp (String) 
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * 
     * @return requete (Requete)
     */
    public Requete getRequete() {
        return requete;
    }

    /**
     * 
     * @param requete (Requete)
     */
    public void setRequete(Requete requete) {
        this.requete = requete;
    }

    /**
     * 
     * @return authentifie (boolean)
     */
    public boolean isAuthentifie() {
        return authentifie;
    }

    /**
     * 
     * @param authentifie (boolean)
     */
    public void setAuthentifie(boolean authentifie) {
        this.authentifie = authentifie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    
    
    
    
    

    
    
}
