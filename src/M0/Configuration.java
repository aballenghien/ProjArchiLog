/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import java.util.List;

/**
 *
 * @author Audrey
 */
public abstract class Configuration extends ElementArchitectural implements Observateur, Observable{
    private List<ElementArchitectural> lstElementsArchitecturaux;

    public Configuration(String nom) {
        super(nom);
    }

    public List<ElementArchitectural> getLstElementsArchitecturaux() {
        return lstElementsArchitecturaux;
    }

    public void setLstElementsArchitecturaux(List<ElementArchitectural> lstElementsArchitecturaux) {
        this.lstElementsArchitecturaux = lstElementsArchitecturaux;
    }

    @Override
    public void setMessage(Message message){
        super.setMessage(message);
        if(!((Configuration)this.getConfiguration()).getNom().equals("")){            
            this.notififerObservateur();
        }
    }
    
    @Override
    public void setReponse(Reponse reponse){
        super.setReponse(reponse);
        if(!((Configuration)this.getConfiguration()).getNom().equals("")){            
            this.notififerObservateur();
        }
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
