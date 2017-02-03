package M0;

import M0.Attachement;
import M2.Sortie;

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

    public Role(Attachement attch) {
        this.attch = attch;
    }   
    

    public Attachement getAttch() {
        return attch;
    }

    public void setAttch(Attachement attch) {
        this.attch = attch;
    }
    
    
    
}
