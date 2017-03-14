/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import java.util.ArrayList;

/**
 *
 * @author Audrey
 */
public class Reponse extends Message{
    private String[][] colonneValeur;

    public Reponse( String user, String mdp, Requete requete) {
        super(user, mdp, requete);
        this.colonneValeur = colonneValeur;
    }
    
    

    public String[][] getColonneValeur() {
        return colonneValeur;
    }

    public void setColonneValeur(String[][] colonneValeur) {
        this.colonneValeur = colonneValeur;
    }
    
    

   
    
    
}
