package M0;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public  class Port extends Sortie {
    private Binding bind;
    private Attachement attch;

    public Port(Binding bind, Attachement attch) {
        this.bind = bind;
        this.attch = attch;
    }  
    

    public Binding getBind() {
        return bind;
    }

    public void setBind(Binding bind) {
        this.bind = bind;
    }

    public Attachement getAttch() {
        return attch;
    }

    public void setAttch(Attachement attch) {
        this.attch = attch;
    }
    
    
    
    
    
}
