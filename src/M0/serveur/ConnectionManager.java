/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.Message;
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

    public Port getExternalSocket() {
        return externalSocket;
    }

    public void setExternalSocket(Port externalSocket) {
        this.externalSocket = externalSocket;
    }

    public Port getSecurityCheck() {
        return securityCheck;
    }

    public void setSecurityCheck(Port securityCheck) {
        this.securityCheck = securityCheck;
    }

    public Port getDbQuery() {
        return dbQuery;
    }

    public void setDbQuery(Port dbQuery) {
        this.dbQuery = dbQuery;
    }
    
    
    
    /**
     * Vérifie la structure du message reçu
     * @return boolean
     */
    public boolean analyserMessage(Message message){
        boolean messageOk = true;
        if(message.getUser().equals("")){
            messageOk = false;
        }
        if(messageOk && message.getMdp().equals("")){
            messageOk = false;
        }
        
        if(messageOk && message.getRequete().getTable().equals("")){
            messageOk = false;
        }
        this.setMessage(message);
        return messageOk;
    }
    

    
    
    
}
