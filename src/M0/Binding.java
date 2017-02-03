package M0;


import M0.Port;
import M2.Liaison;
import M2.Sortie;


public class Binding extends Liaison{
    
    private Port entree;
    private Port sortie;

    public Binding(Port entree, Port sortie) {
        this.entree = entree;
        this.sortie = sortie;
    }
    
    
    


}
