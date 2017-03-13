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
    private ArrayList<Object> contenuReponse;

    public Reponse(int id, String objet, String contenu) {
        super(id, objet, contenu);
        this.contenuReponse = new ArrayList<>();
    } 
    
    public ArrayList<Object> getContenuReponse() {
        return contenuReponse;
    }

    public void setContenuReponse(ArrayList<Object> contenuReponse) {
        this.contenuReponse = contenuReponse;
    }
    
    
    
}
