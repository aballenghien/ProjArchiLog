/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.communication;

import java.util.ArrayList;

/**
 * La requête s'adresse à la base de données,
 * Elle doit indiquer plusieurs informations de recherche:
 * - quelle table est concernées
 * - quelles colonnes retourner
 * - le condition spécifiques de recherche en fonction des valeurs
 * @author Audrey, Bertrand
 */
public class Requete {
    private String table;
    private ArrayList<String> colonnes;
    private ArrayList<String> conditions;

    /**
     * initialisation des listes
     */
    public Requete() {
        this.colonnes = new ArrayList();
        this.conditions = new ArrayList();
    }
    
    

    /**
     * 
     * @return table(String) 
     */
    public String getTable() {
        return table;
    }
    
    
    /**
     * 
     * @param table (String)
     */
    public void setTable(String table) {
        this.table = table;
    }

    /**
     * 
     * @return colonnes (ArrayList<String>)
     */
    public ArrayList<String> getColonnes() {
        return colonnes;
    }

   /**
    * 
    * @return conditions (ArrayList<String>)
    */
    public ArrayList<String> getConditions() {
        return conditions;
    }
    
    /**
     * Ajouter le nom de la colonne dont on souhaite récupérer les données
     * @param colonne (String)
     */
    public void addColonne(String colonne){
        this.colonnes.add(colonne);
    }
    
    /**
     * Ajouter un prédicat qui déterminera les valeurs de retour
     * @param condition (String) 
     */
    public void addCondition(String condition){
        this.conditions.add(condition);
    }
    
    
    
}
