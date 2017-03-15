/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.communication;

/**
 *
 * @author Audrey
 */
public interface Observable {
    
    public void DeterminerObservateur(Observateur o);
    public void notififerObservateur();
    
}
