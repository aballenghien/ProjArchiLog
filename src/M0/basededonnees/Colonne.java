/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.basededonnees;

import java.util.ArrayList;

/**
 * Dans une base de données, une table est composé de colonne
 * Une colonne est défini par un nom et une liste de valeurs
 * @author Audrey, Bertrand
 */
public class Colonne {
   private String nom;
   private ArrayList<Object> lstValeurs;

   public Colonne(){
       this.lstValeurs = new ArrayList<>();
   }
   
   /**
    * @return nom(String)
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
     * @return lstValeurs (ArrayList Object)
     */
    public ArrayList<Object> getLstValeurs() {
        return lstValeurs;
    }
    
    /**
     * Ajoute une valeur à la liste
     * @param valeur (Object)
     */
    public void addValeur(Object valeur){
        this.lstValeurs.add(valeur);
    }
   
   
}
