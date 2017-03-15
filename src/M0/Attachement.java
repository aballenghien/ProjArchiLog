package M0;



/**
 * Un attachement est une liaison particulère entre un composant et un connecteur
 * Il est relié au composant par un port et au connecteur par un rôle
 * @author Audrey, Bertrand
 */
public class Attachement extends Liaison{
    
    private Port port;
    private Role role;

    /**
     * Constructeur de l'attachement
     * @param nom 
     */
    public Attachement(String nom) {
        super(nom);
        this.getLstSorties().add(this.port);
        this.getLstSorties().add(this.role);
    }
    

    /**
     * getPort()
     * @return port 
     */
    public Port getPort() {
        return port;
    }

    /**
     * 
     * @param port 
     */
    public void setPort(Port port) {
        this.port = port;
    }

    /**
     * 
     * @return Role 
     */
    public Role getRole() {
        return role;
    }

    /**
     * 
     * @param role 
     */
    public void setRole(Role role) {
        this.role = role;
    }

	
    

}
