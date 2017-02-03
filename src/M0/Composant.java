package M0;


import M0.Propriete;
import M2.Contrainte;
import M2.ElementArchitectural;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public abstract class Composant {
    protected List<Contrainte> lstContraintes;
    protected List<Propriete> lstPriorites;
    private Port entree;
    private Port sortie;
    
    public Composant (Port entree, Port sortie){
        this.entree = entree;
        this.sortie = sortie;
    }

    public List<Contrainte> getLstContraintes() {
        return lstContraintes;
    }

    public void setLstContraintes(List<Contrainte> lstContraintes) {
        this.lstContraintes = lstContraintes;
    }

    public List<Propriete> getLstPriorites() {
        return lstPriorites;
    }

    public void setLstPriorites(List<Propriete> lstPriorites) {
        this.lstPriorites = lstPriorites;
    }

    

    
    
    
    
    
}
