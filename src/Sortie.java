/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class Sortie {
    Interface inter;
    Liaison liaison;
    
    public Sortie(){
        
    }
    
    public Liaison getLiaison() {
		return liaison;
	}

	public void setLiaison(Liaison liaison) {
		this.liaison = liaison;
	}

	public Interface getInter() {
        return inter;
    }

    public void setInter(Interface inter) {
        this.inter = inter;
    }
    
    
    
}
