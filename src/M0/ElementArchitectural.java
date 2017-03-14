/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import java.util.ArrayList;

/**
 *
 * @author Audrey
 */
public class ElementArchitectural {    
    private ArrayList<Sortie> lstSorties;
    private Observateur configuration;
    private Message message;
    protected Reponse reponse;
    private String nom;

    public ElementArchitectural(String nom) {
        this.nom = nom;
        this.lstSorties = new ArrayList<>();
    }

    public ArrayList<Sortie> getLstSorties() {
        return lstSorties;
    }

    public void setLstSorties(ArrayList<Sortie> lstSorties) {
        this.lstSorties = lstSorties;
    }

    public Observateur getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Observateur configuration) {
        this.configuration = configuration;
    }   

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public void setReponse(Reponse reponse) {
        this.reponse = reponse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
    
    
    
    
    
    
}
