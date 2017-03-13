/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Observable;
import M0.Observateur;
import M0.Port;

/**
 *
 * @author E101746T
 */
public class Database extends Composant {
    
    private Port queryInt;
    private Port securityManagement;
    
    public Database(Port queryInt, Port securityManagement, String nom) {
        super(nom);
        this.queryInt = queryInt;
        this.securityManagement = securityManagement;
        this.getLstSorties().add(this.queryInt);
        this.getLstSorties().add(this.securityManagement);
        
    }

    
}
