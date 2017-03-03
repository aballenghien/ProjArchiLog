package M0;


import M0.Port;
import M2.Liaison;


public class Binding extends Liaison{
    
    private Port entree;
    private Port sortie;
    private String nom;

    public Binding(String nom) {
        this.nom = nom;
    }

    public Port getEntree() {
        return entree;
    }

    public void setEntree(Port entree) {
        this.entree = entree;
    }

    public Port getSortie() {
        return sortie;
    }

    public void setSortie(Port sortie) {
        this.sortie = sortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    


}
