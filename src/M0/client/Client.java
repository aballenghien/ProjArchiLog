/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.client;

import M0.Composant;
import M0.Port;
import M0.Propriete;
import M0.SystemCS;
import M2.*;
import java.util.ArrayList;

/**
 *
 * @author Audrey
 */
public class Client extends Composant{
    
    
    public Client(Propriete visualisation, Propriete codeSource, Propriete performance, Port sendRequest){        
        super.lstPriorites = new ArrayList<>();
        super.lstPriorites.add(visualisation);
        super.lstPriorites.add(codeSource);
        super.lstPriorites.add(performance);
        super.lstPorts.add(sendRequest);
    }
    
}
