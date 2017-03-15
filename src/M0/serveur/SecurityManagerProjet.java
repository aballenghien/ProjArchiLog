/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.Composant;
import M0.communication.Observable;
import M0.communication.Observateur;
import M0.Port;

/** 
 * SecurityManager est un composant particulier communiquant avec les la base de données afin d'authentifier les message qu'il reçoit
 * du composant ConnectionManager
 * Il est associé à deux ports:
 * - Cquery qui communique avec ConnectionManager
 * - securityAut qui communique avec la base de données
 * @author Audrey, Bertrand
 */
public class SecurityManagerProjet extends Composant{
    
    private Port cQuery;
    private Port securityAut;
  
    /**
     * 
     * @param cQuery (Port)
     * @param securityAut (Port)
     * @param nom (String)
     */
    public SecurityManagerProjet(Port cQuery, Port securityAut, String nom) {
        super(nom);
        this.cQuery = cQuery;
        this.securityAut = securityAut;
        this.getLstSorties().add(this.cQuery);
        this.getLstSorties().add(this.securityAut);
    }

    /**
     * 
     * @return cQuery (Port)
     */
    public Port getcQuery() {
        return cQuery;
    }

    /**
     * 
     * @param cQuery (Port)
     */
    public void setcQuery(Port cQuery) {
        this.cQuery = cQuery;
    }

    /**
     * 
     * @return securityAut (Port)
     */
    public Port getSecurityAut() {
        return securityAut;
    }

    /**
     * 
     * @param securityAut (Port)
     */
    public void setSecurityAut(Port securityAut) {
        this.securityAut = securityAut;
    }
    
    


    
}
