package M0;


import M0.Port;
import M2.Liaison;


public class Attachement extends Liaison{
    private Port port;
    private Role role;
    private String nom;

    public Attachement(String nom) {
        this.nom = nom;
    }
    
    

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
	
    

}
