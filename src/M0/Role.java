package M0;

import java.util.ArrayList;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Un role est la sortie d'un connecteur ou celle d'un attachment, il permet de relier un connecteur à un attachement
 * @author Audrey, Bertrand
 */
public class Role extends Sortie{
    private ArrayList<Attachement> lstAttchs;
    private Connecteur connect;

    /**
     * 
     * @param attch (Attachement)
     * @param connect (Connecteur)
     * @param nom (String)
     */
    public Role(Attachement attch,Connecteur connect, String nom) {
        super(nom);
        this.lstAttchs = new ArrayList<>();
        this.lstAttchs.add(attch);
        this.connect = connect;
    }   
    

    public ArrayList<Attachement> getLstAttch() {
        return lstAttchs;
    }

    public void addAttch(Attachement attch) {
        this.lstAttchs.add(attch);
    }
    
    public Attachement getAttachByNom(String nom){
        for(Attachement a: this.lstAttchs){
            if(a!=null && a.getNom().equals(nom)){
                return a;
            }
        }
        return this.lstAttchs.get(0);
    }

    public Connecteur getConnect() {
        return connect;
    }

    public void setConnect(Connecteur connect) {
        this.connect = connect;
    }
    
    
    
    
    
}
