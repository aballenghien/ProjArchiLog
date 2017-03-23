package execution;


import execution.CompositionSystem;
import M0.communication.Requete;
import M0.communication.Message;
import M0.communication.Reponse;
import M0.*;
import M0.client.Client;
import M0.serveur.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main_project {
    

            

	public static void main(String[] args) throws Exception {
            SystemCS sys = null;
            try {
                sys = CompositionSystem.construireLeSystem();
            } catch (Exception ex) {
                Logger.getLogger(Main_project.class.getName()).log(Level.SEVERE, null, ex);
            }
            Requete req = new Requete();
            req.setTable("t1");
            req.addColonne("c1");
            req.addCondition("c2=v22");
            Client client = CompositionSystem.connecterUnClient(sys, CompositionSystem.NOM_CLIENT);
            Message mes = new Message("audrey","audrey",req,client);
            Reponse rep = sys.getClientByNom(client.getNom()).EnvoyerUneRequete(mes);
            System.out.println(rep.toString());
                
	}
        
        
        


}
