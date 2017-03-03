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
    protected List<Port> lstPorts;
    protected Composant configuration;
    protected List<Composant> lstComposants;
    
    public Composant (){
        this.lstComposants = new ArrayList<>();
        this.lstPorts = new ArrayList<>();
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

    public List<Port> getLstPorts() {
        return lstPorts;
    }

    public void setLstPorts(List<Port> lstPorts) {
        this.lstPorts = lstPorts;
    }

    public List<Composant> getLstComposants() {
        return lstComposants;
    }

    public void setLstComposants(List<Composant> lstComposants) {
        this.lstComposants = lstComposants;
    }

    public Composant getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Composant configuration) {
        this.configuration = configuration;
    }
    
    
    

    

    
    
    
    
    
}
