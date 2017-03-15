/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M0.communication.*;
import java.util.ArrayList;

/**
 * Element du système
 * @author Audrey, Bertrand
 */
public class ElementArchitectural {    
    private ArrayList<Sortie> lstSorties;
    private Observateur configuration;
    private Message message;
    protected Reponse reponse;
    private String nom;

    /**
     * construit l'objet et instancie les listes
     * @param nom 
     */
    public ElementArchitectural(String nom) {
        this.nom = nom;
        this.lstSorties = new ArrayList<>();
    }

    /**
     * 
     * @return lstSortie (ArrayList<Sortie>)
     */
    public ArrayList<Sortie> getLstSorties() {
        return lstSorties;
    }

    /**
     * 
     * @return configuration (observateur)
     */
    public Observateur getConfiguration() {
        return configuration;
    }

    /**
     * Element architectural chargé de supervisé les élements architecturaux le composant
     * @param configuration (Observateur)
     */
    public void setConfiguration(Observateur configuration) {
        this.configuration = configuration;
    }   

    /**
     * 
     * @return message (Message)
     */
    public Message getMessage() {
        return message;
    }

    /**
     * 
     * @param message (Message)
     */
    public void setMessage(Message message) {
        this.message = message;
    }

    /**
     * 
     * @return reponse (Reponse)
     */
    public Reponse getReponse() {
        return reponse;
    }

    /**
     * 
     * @param reponse (Reponse) 
     */
    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    /**
     * 
     * @return nom (String)
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom (String)
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    
    
    
    
    
    
}
