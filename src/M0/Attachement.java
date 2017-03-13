package M0;


import M0.Port;


public class Attachement extends Liaison{
    private Port port;
    private Role role;

    public Attachement(String nom) {
        super(nom);
        this.getLstSorties().add(this.port);
        this.getLstSorties().add(this.role);
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
