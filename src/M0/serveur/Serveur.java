/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Configuration;
import M0.Observable;
import M0.Observateur;
import M0.Port;
import M0.SystemCS;

/**
 *
 * @author Audrey
 */
public class Serveur extends Configuration{
    
    private ConnectionManager connectionManager;
    private SecurityManagerProjet securityManager;
    private Database database;
    private Port receiveRequest;
    private Port internalServeur;
    

    public Serveur(ConnectionManager connectionManager, SecurityManagerProjet securityManager, Database database, Port receiveRequest, Port internalServeur, String nom) {
        super(nom);
        this.connectionManager = connectionManager;
        this.securityManager = securityManager;
        this.database = database;
        this.getLstElementsArchitecturaux().add (this.connectionManager);
        this.getLstElementsArchitecturaux().add (this.securityManager);
        this.getLstElementsArchitecturaux().add (this.database);
        this.receiveRequest = receiveRequest;
        this.internalServeur = internalServeur;
        this.getLstSorties().add(this.receiveRequest);
        this.getLstSorties().add(this.internalServeur);
    }   

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public SecurityManagerProjet getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManagerProjet securityManager) {
        this.securityManager = securityManager;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public Port getReceiveRequest() {
        return receiveRequest;
    }

    public void setReceiveRequest(Port receiveRequest) {
        this.receiveRequest = receiveRequest;
    }

    public Port getInternalServeur() {
        return internalServeur;
    }

    public void setInternalServeur(Port internalServeur) {
        this.internalServeur = internalServeur;
    }

    
    
    @Override
    public void actualiser(Observable o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
