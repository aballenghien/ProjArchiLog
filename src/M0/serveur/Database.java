/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Port;

/**
 *
 * @author E101746T
 */
public class Database extends Composant {
    
    public Database(Port queryInt, Port securityManagement) {
        this.lstPorts.add(queryInt);
        this.lstPorts.add(securityManagement);
    }
    
}
