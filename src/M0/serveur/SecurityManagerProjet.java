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
public class SecurityManagerProjet extends Composant{
    
    private Port cQuery;
    private Port securityAut;
  
    public SecurityManagerProjet(Port cQuery, Port securityAut, String nom) {
        super(nom);
        this.cQuery = cQuery;
        this.securityAut = securityAut;
        this.getLstSorties().add(this.cQuery);
        this.getLstSorties().add(this.securityAut);
    }

    public Port getcQuery() {
        return cQuery;
    }

    public void setcQuery(Port cQuery) {
        this.cQuery = cQuery;
    }

    public Port getSecurityAut() {
        return securityAut;
    }

    public void setSecurityAut(Port securityAut) {
        this.securityAut = securityAut;
    }
    
    


    
}
