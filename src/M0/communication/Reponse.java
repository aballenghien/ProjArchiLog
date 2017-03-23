/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.communication;

import M0.ElementArchitectural;
import M0.client.Client;
import java.util.ArrayList;

/**
 * Une réponse est un message particulier, en plus de la requête et des informations nécessaires 
 * à l'authentification, il y a un ensemble de valeur extraites de la base de données 
 * @author Audrey, Bertrand
 */
public class Reponse extends Message{
    private String[][] colonneValeur;

    /**
     * 
     * @param user (String)
     * @param mdp (String)
     * @param requete (Requete)
     * @param elem (ElementArchitectural)
     */
    public Reponse( String user, String mdp, Requete requete, Client elem) {
        super(user, mdp, requete, elem);
        this.colonneValeur = new String [0][0];
    }
    
    

    /**
     * 
     * @return colonneValeur (String[][])
     */
    public String[][] getColonneValeur() {
        return colonneValeur;
    }

    /**
     * 
     * @param colonneValeur (String [][])
     */
    public void setColonneValeur(String[][] colonneValeur) {
        this.colonneValeur = colonneValeur;
    }

    @Override
    public String toString() {
        return "Reponse{" + "colonneValeur=" + colonneValeur[0][0]+"}";
    }
    
    
    
    

   
    
    
}
