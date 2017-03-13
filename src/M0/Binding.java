package M0;


import M0.Port;


public class Binding extends Liaison{
    
    private Port entree;
    private Port sortie;

    public Binding(String nom, Port entree, Port sortie) {
        super(nom);
        this.entree = entree;
        this.sortie = sortie;
        this.getLstSorties().add(this.entree);
        this.getLstSorties().add(this.sortie);
    }

    public Port getEntree() {
        return entree;
    }

    public void setEntree(Port entree) {
        this.entree = entree;
    }

    public Port getSortie() {
        return sortie;
    }

    public void setSortie(Port sortie) {
        this.sortie = sortie;
    }


    
    
    


}
