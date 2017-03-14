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
public class Table {
    String nom;
    ArrayList<Colonne> lstColonnes;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Colonne> getLstColonnes() {
        return lstColonnes;
    }

    public void setLstColonnes(ArrayList<Colonne> lstColonnes) {
        this.lstColonnes = lstColonnes;
    }
    
    
}
