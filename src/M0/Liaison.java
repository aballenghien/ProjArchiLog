package M0;

import M0.ElementArchitectural;
import M0.Observable;
import M0.Observateur;



public abstract class Liaison extends ElementArchitectural implements Observable{
	

    public Liaison(String nom) {
        super(nom);
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
