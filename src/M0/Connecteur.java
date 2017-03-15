package M0;

import M0.communication.*;


/**
 * Un connecteur est un élément architectural qui relie deux composants 
 * Chaque Role, de bout en bout, est relié à un attachment
 * @author Audrey, Bertrand
 */
public class Connecteur extends ElementArchitectural implements Observable{

    /**
     * glue : élment interne au connecteur, il relie les deux rôles
     */
    private Glue laGlue;
    private Role entree;
    private Role sortie; 

    /**
     * construction de l'objet et initialisation des listes
     * @param nom 
     */
    public Connecteur(String nom) {
        super(nom);
        this.getLstSorties().add(this.entree);
        this.getLstSorties().add(this.sortie);
    }

    /**
     * 
     * @return laGlue de type Glue
     */
    public Glue getLaGlue() {
        return laGlue;
    }

    /**
     * 
     * @param laGlue  de type Glue
     */
    public void setLaGlue(Glue laGlue) {
        this.laGlue = laGlue;
    }

    /**
     * retourne le rôle considéré comme l'entrée, c'est à dire le primer rôle rencontré lors de l'émission d'un message
     * @return entree de type Role
     */
    public Role getEntree() {
        return entree;
    }

    /**
     * entrée : premier rôle rencontré lors de l'envoie d'un message
     * @param entree de type Role
     */
    public void setEntree(Role entree) {
        this.entree = entree;

    }

    /**
     * Retourne la sortie, c'est à dire le premier rôle rencontré lors de l'envoi d'une réponse
     * @return sortie de type Role
     */
    public Role getSortie() {
        return sortie;
    }

    /**
     * sortie : premier rôle rencontré lors de l'envoi d'une réponse
     * @param sortie de type Role
     */
    public void setSortie(Role sortie) {
        this.sortie = sortie;
    }

    /**
     * met à jour de le message et notifie directement l'observateur
     * @param message 
     */
    public void transmettreMessage(Message message){
        this.setMessage(message);
        this.notififerObservateur();
    }
    
    /**
     * met à jour la configuration
     * @param o 
     */
    @Override
    public void DeterminerObservateur(Observateur o) {
        this.setConfiguration(o);
    }

    /**
     * avertit l'observateur
     */
    @Override
    public void notififerObservateur() {
        this.getConfiguration().actualiser(this);
    }
        
    
	
	

}
