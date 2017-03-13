package M0;

import M0.Attachement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class Role extends Sortie{
    private Attachement attch;
    private Connecteur connect;

    public Role(Attachement attch,Connecteur connect, String nom) {
        super(nom);
        this.attch = attch;
        this.connect = connect;
    }   
    

    public Attachement getAttch() {
        return attch;
    }

    public void setAttch(Attachement attch) {
        this.attch = attch;
    }

    public Connecteur getConnect() {
        return connect;
    }

    public void setConnect(Connecteur connect) {
        this.connect = connect;
    }
    
    
    
    
    
}
