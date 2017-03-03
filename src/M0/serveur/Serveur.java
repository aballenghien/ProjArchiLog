/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Port;
import M0.SystemCS;

/**
 *
 * @author Audrey
 */
public class Serveur extends Composant{
    
    ConnectionManager connectionManager;
    SecurityManager securityManager;
    Database database;

    public Serveur(ConnectionManager connectionManager, SecurityManager securityManager, Database database, Port receiveRequest) {
        this.connectionManager = connectionManager;
        this.securityManager = securityManager;
        this.database = database;
        this.lstComposants.add (this.connectionManager);
        this.lstComposants.add (this.securityManager);
        this.lstComposants.add (this.database);
        this.lstPorts.add(receiveRequest);
        super.configuration = SystemCS.getInstance();
    }
    
    public void initConfiguration(){
        this.connectionManager.setConfiguration(this);
        this.securityManager.setConfiguration(this);
        this.database.setConfiguration(this);
    }
    
}
