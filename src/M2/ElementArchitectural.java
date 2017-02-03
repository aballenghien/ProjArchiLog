package M2;

import java.util.ArrayList;

public abstract class ElementArchitectural {
	private ArrayList<Configuration> lesConfigurations;
	private ArrayList<Sortie> entree;
	private ArrayList<Sortie> sortie;

    public ArrayList<Configuration> getLesConfigurations() {
        return lesConfigurations;
    }

    public void setLesConfigurations(ArrayList<Configuration> lesConfigurations) {
        this.lesConfigurations = lesConfigurations;
    }

    public ArrayList<Sortie> getEntree() {
        return entree;
    }

    public void setEntree(ArrayList<Sortie> entree) {
        this.entree = entree;
    }

    public ArrayList<Sortie> getSortie() {
        return sortie;
    }

    public void setSortie(ArrayList<Sortie> sortie) {
        this.sortie = sortie;
    }

    
	
        

}
