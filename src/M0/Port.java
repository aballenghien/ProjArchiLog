package M0;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Sortie d'un élément architectural relié soit à un attachment soit à un binding, il ne peut pas être relié aux deux à la fois
 * @author Audrey, Bertrand
 */
public  class Port extends Sortie {
    private Binding bind;
    private Attachement attch;
    private ElementArchitectural compo;

    public Port(Binding bind, Attachement attch,String nom) throws Exception {        
        super(nom);
        this.bind = bind;
        if(bind== null){
            this.attch = attch;
        }else{
            throw new Exception("Le port ne peut pas être relié à un binding et à un attachement");
        }
    }  
    

    /**
     * 
     * @return bind (Binding) 
     */
    public Binding getBind() {
        return bind;
    }

    /**
     * 
     * @param bind (Binding)
     */
    public void setBind(Binding bind) {
        this.bind = bind;
    }

    /**
     * 
     * @return attch (Attachement)
     */
    public Attachement getAttch() {
        return attch;
    }

    /**
     * 
     * @param attch (Attachement)
     */
    public void setAttch(Attachement attch) {
        this.attch = attch;
    }

    /**
     * Element architectural auquel appartient le port
     * @return compo (Element Architectural)
     */
    public ElementArchitectural getCompo() {
        return compo;
    }

    /**
     * Déterminer l'élément architectural auquel appartient le port
     * @param compo (ElementArchitectural)
     */
    public void setCompo(ElementArchitectural compo) {
        this.compo = compo;
    }
    
    
    
    
    
    
    
}
