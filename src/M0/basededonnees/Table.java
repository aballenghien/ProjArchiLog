/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.basededonnees;

import java.util.ArrayList;

/**
 * Une base de données est composée de table définit par un nom et une liste de colonne
 * @author Audrey, Bertrand
 */
public class Table {
    String nom;
    ArrayList<Colonne> lstColonnes;

    /**
     * initiliase la liste
     */
    public Table(){
        this.lstColonnes = new ArrayList<>();
    }
    
    /**
     * 
     * @return nom (String)
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom (String)
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return lstColonnes(ArrayList Colonne)
     */
    public ArrayList<Colonne> getLstColonnes() {
        return lstColonnes;
    }

    /**
     * Ajoute une colonne à la liste
     * @param colonne (Colonne)
     */
    public void addColonne(Colonne colonne){
        this.lstColonnes.add(colonne);
    }
    
    
}
