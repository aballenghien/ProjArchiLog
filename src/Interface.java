
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class Interface {
    List<Sortie> lstSorties;
    ElementArchitectural element;
    
    public Interface(){
        
    }
    
    

    public ElementArchitectural getElement() {
		return element;
	}

	public void setElement(ElementArchitectural element) {
		this.element = element;
	}

	public List<Sortie> getLstSorties() {
        return lstSorties;
    }

    public void setLstSorties(List<Sortie> lstSorties) {
        this.lstSorties = lstSorties;
    }
    
    
}
