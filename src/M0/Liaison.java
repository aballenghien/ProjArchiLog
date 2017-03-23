package M0;


import M0.communication.*;


/**
 * Fait la connection entre deux élements
 * @author Audrey, Bertrand
 */
public abstract class Liaison extends ElementArchitectural implements Observable{
	

    /**
     * 
     * @param nom (String)
     */
    public Liaison(String nom) {
        super(nom);
    }

    
    

    /**
     * met à jour la configuration
     * @param o (Observateur)
     */
    @Override
    public void DeterminerObservateur(Observateur o) {
        this.setConfiguration(o);
    }

    /**
     * avertit la configuration d'un changement d'état
     */
    @Override
    public void notififerObservateur() {
        this.getConfiguration().actualiser(this);
    }
	

}
