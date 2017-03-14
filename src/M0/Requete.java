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
public class Requete {
    private String table;
    private ArrayList<String> colonnes;
    private ArrayList<String> conditions;

    public Requete() {
        this.colonnes = new ArrayList();
        this.conditions = new ArrayList();
    }
    
    

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public ArrayList<String> getColonnes() {
        return colonnes;
    }

    public ArrayList<String> getConditions() {
        return conditions;
    }
    
    public void addColonne(String colonne){
        this.colonnes.add(colonne);
    }
    
    public void addCondition(String condition){
        this.conditions.add(condition);
    }
    
    
    
}
