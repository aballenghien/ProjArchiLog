package M0;


import M0.Port;
import M2.Liaison;
import M2.Sortie;


public class Attachement extends Liaison{
    private Port port;
    private Role role;

    public Attachement(Port port, Role role) {
        this.port = port;
        this.role = role;
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
