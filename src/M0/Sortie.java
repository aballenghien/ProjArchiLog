package M0;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Un sortie a un nom, elle peut être un port ou un rôle
 * @author Audrey, Bertrand
 */
public abstract class Sortie {
    
    private String nom;
    public Sortie(String nom){
        this.nom = nom;
    }   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    
}
