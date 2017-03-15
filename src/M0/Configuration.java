/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.communication.*;
import java.util.ArrayList;
import java.util.List;

/**
 *La configuration est un élément architectural qui contient plusieurs éléments architecturaux et les supervise
 * Une configuration peut elle aussi être supervisé par une autre configuration
 * @author Audrey, Bertrand
 */
public abstract class Configuration extends ElementArchitectural implements Observateur, Observable{
    private List<ElementArchitectural> lstElementsArchitecturaux;

    /**
     * construit l'objet et initialise les listes
     * @param nom 
     */
    public Configuration(String nom) {
        super(nom);
        this.lstElementsArchitecturaux = new ArrayList<>();
    }

    /**
     * retourne la liste des elements architecturaux contenus dans la configuration
     * @return 
     */
    public List<ElementArchitectural> getLstElementsArchitecturaux() {
        return lstElementsArchitecturaux;
    }


    /**
     * mise à jour du message
     * avertissement de l'observateur uniquement s'il y en a un
     * @param message 
     */
    @Override
    public void setMessage(Message message){
        super.setMessage(message);
        if(!((Configuration)this.getConfiguration()).getNom().equals("")){            
            this.notififerObservateur();
        }
    }
    
    /**
     * Mise à jour de la réponse
     * Avertissement de l'observateur uniquement s'il y en a un
     * @param reponse 
     */
    @Override
    public void setReponse(Reponse reponse){
        super.setReponse(reponse);
        if(!((Configuration)this.getConfiguration()).getNom().equals("")){            
            this.notififerObservateur();
        }
    }

    /**
     * Mise à jour de l'observateur
     * @param o 
     */
    @Override
    public void DeterminerObservateur(Observateur o) {
        this.setConfiguration(o);
    }

    /**
     * Avertissement de l'observateur dans le cas d'un changement d'état
     */
    @Override
    public void notififerObservateur() {
        this.getConfiguration().actualiser(this);
    }

    
    
    
    
    
}
