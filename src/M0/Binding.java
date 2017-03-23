package M0;


/**
 * Un binding est une liaison particulière entre un composant et sa configuration
 * Elle relie deux port, le port interne à la configuration et le port d'un composant supervisé par la configuration
 * @author Audrey, Bertrand
 */
public class Binding extends Liaison{
    
    private Port entree;
    private Port sortie;

    /**
     * 
     * @param nom (String)
     * @param entree (Port)
     * @param sortie (Port)
     */
    public Binding(String nom, Port entree, Port sortie) {
        super(nom);
        this.entree = entree;
        this.sortie = sortie;
        this.getLstSorties().add(this.entree);
        this.getLstSorties().add(this.sortie);
    }

    /**
     * 
     * @return entree de type Port
     */
    public Port getEntree() {
        return entree;
    }

    /**
     * 
     * @param entree(Port)
     */
    public void setEntree(Port entree) {
        this.entree = entree;
    }

    /**
     * 
     * @return sortie de type Port
     */
    public Port getSortie() {
        return sortie;
    }

    /**
     * 
     * @param sortie (Port)
     */
    public void setSortie(Port sortie) {
        this.sortie = sortie;
    }


    
    
    


}
