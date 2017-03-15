package M0;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Un role est la sortie d'un connecteur ou celle d'un attachment, il permet de relier un connecteur à un attachement
 * @author Audrey, Bertrand
 */
public class Role extends Sortie{
    private Attachement attch;
    private Connecteur connect;

    /**
     * 
     * @param attch (Attachement)
     * @param connect (Connecteur)
     * @param nom (String)
     */
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
