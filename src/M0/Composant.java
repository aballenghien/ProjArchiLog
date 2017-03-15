package M0;


import M0.communication.*;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Un composant est un élément architectural du systèm supervisé par une configuration
 * Il implémente l'interface observable, il doit donc régulièrement notifer son observateur
 * @author Audrey, Bertrand
 */
public abstract class Composant extends ElementArchitectural implements Observable{
    private List<Contrainte> lstContraintes;
    private List<Propriete> lstProprietes;
    
    /**
     * construction de l'object et initialisation des listes
     * @param nom 
     */
    public Composant (String nom){
        super(nom);
        this.lstProprietes = new ArrayList<>();
        this.lstContraintes = new ArrayList<>();
    }

    public List<Contrainte> getLstContraintes() {
        return lstContraintes;
    }

    public List<Propriete> getLstProprietes() {
        return lstProprietes;
    }


    /**
     * A chaque mis à jour du message, l'observateur doit être avertit pour pouvoir transmettre le message
     * @param message 
     */
    @Override
    public void setMessage(Message message){
        super.setMessage(message);
        this.notififerObservateur();
    }
    
    /**
     * A chaque mise à jour de la réponse, l'observateur doit être vaertit afin de transmetre la réponse
     * @param reponse 
     */
     @Override
    public void setReponse(Reponse reponse){
        super.setReponse(reponse);
        this.notififerObservateur();
    }

     /**
      * Ajout d'une configuration pour le composant
      * @param o 
      */
    @Override
    public void DeterminerObservateur(Observateur o) {
        this.setConfiguration(o);
        
    }

    /**
     * Avertissement de l'observateur que l'objet a été mis à jour
     */
    @Override
    public void notififerObservateur() {
        this.getConfiguration().actualiser(this);
    }

    
    
    
    

    

    
    
    
    
    
}
