/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

import M2.*;
import java.util.ArrayList;

/**
 *
 * @author Audrey
 */
public class Client extends Composant{
    public Client(Propriete visualisation, Propriete codeSource, Propriete performance, Port sortieClient){
        super(null,sortieClient);
        super.lstPriorites = new ArrayList<>();
        super.lstPriorites.add(visualisation);
        super.lstPriorites.add(codeSource);
        super.lstPriorites.add(performance);
    }
    
}