package M0;

import M2.Glue;


public class Connecteur{
	
	private Glue laGlue;
        private Role entree;
        private Role sortie; 
        private String nom;

    public Connecteur( String nom) {
        this.nom = nom;
    }

    public Glue getLaGlue() {
        return laGlue;
    }

    public void setLaGlue(Glue laGlue) {
        this.laGlue = laGlue;
    }

    public Role getEntree() {
        return entree;
    }

    public void setEntree(Role entree) {
        this.entree = entree;
    }

    public Role getSortie() {
        return sortie;
    }

    public void setSortie(Role sortie) {
        this.sortie = sortie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
        
    
	
	

}
