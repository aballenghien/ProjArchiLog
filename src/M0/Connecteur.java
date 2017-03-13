package M0;

import M2.Glue;
import java.util.ArrayList;


public class Connecteur extends ElementArchitectural implements Observable{
	
	private Glue laGlue;
        private Role entree;
        private Role sortie; 

    public Connecteur(String nom) {
        super(nom);
        this.setLstSorties(new ArrayList<Sortie>());
        this.getLstSorties().add(this.entree);
        this.getLstSorties().add(this.sortie);
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

    public void transmettreMessage(Message message){
        this.setReponse(null);
        this.setMessage(message);
        this.notififerObservateur();
    }
    @Override
    public void DeterminerObservateur(Observateur o) {
        this.setConfiguration(o);
    }

    @Override
    public void notififerObservateur() {
        this.getConfiguration().actualiser(this);
    }
        
    
	
	

}
