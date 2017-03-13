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
public class ConnectionManager extends Composant{

    private Port externalSocket;
    private Port securityCheck;
    private Port dbQuery;
    public ConnectionManager(Port externalSocket, Port securityCheck, Port dbQuery, String nom) {
        super(nom);
        this.externalSocket = externalSocket;
        this.securityCheck = securityCheck;
        this.dbQuery = dbQuery;
        this.getLstSorties().add(this.externalSocket);
        this.getLstSorties().add(this.securityCheck);
        this.getLstSorties().add(this.dbQuery);
    }

    
    
    
}
