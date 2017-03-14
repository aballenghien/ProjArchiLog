package M0;


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
public abstract class Composant extends ElementArchitectural implements Observable{
    private List<Contrainte> lstContraintes;
    private List<Propriete> lstProprietes;
    
    public Composant (String nom){
        super(nom);
        this.lstProprietes = new ArrayList<>();
        this.lstContraintes = new ArrayList<>();
    }

    public List<Contrainte> getLstContraintes() {
        return lstContraintes;
    }

    public void setLstContraintes(List<Contrainte> lstContraintes) {
        this.lstContraintes = lstContraintes;
    }

    public List<Propriete> getLstProprietes() {
        return lstProprietes;
    }

    public void setLstProprietes(List<Propriete> lstProprietes) {
        this.lstProprietes = lstProprietes;
    }
    @Override
    public void setMessage(Message message){
        super.setMessage(message);
        this.notififerObservateur();
    }
    
     @Override
    public void setReponse(Reponse reponse){
        super.setReponse(reponse);
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
