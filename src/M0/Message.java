/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

/**
 *
 * @author Audrey
 */
public class Message {
    private String user;
    private String mdp;
    private Requete requete;
    private boolean authentifie;

    public Message(String user, String mdp, Requete requete) {
        this.user = user;
        this.mdp = mdp;
        this.requete = requete;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Requete getRequete() {
        return requete;
    }

    public void setRequete(Requete requete) {
        this.requete = requete;
    }

    public boolean isAuthentifie() {
        return authentifie;
    }

    public void setAuthentifie(boolean authentifie) {
        this.authentifie = authentifie;
    }
    
    
    
    

    
    
}
