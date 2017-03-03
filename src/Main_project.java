
import M0.*;
import M0.client.Client;
import M0.serveur.*;


public class Main_project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            
            
            //Construction client
            //propriété client
            Propriete visualisation= new Propriete();
            Propriete codeSource= new Propriete();
            Propriete performance= new Propriete();
            //binding client connecteur rpc    
            Connecteur rpc= new Connecteur ("rpc");
            Attachement attachementClientRpc= new Attachement ("attachementClientRpc");
            Port sendRequest= new Port(null, attachementClientRpc);
            Role roleAttachementClientRPC= new Role(attachementClientRpc);
            //instanciation du rpc
            attachementClientRpc.setPort(sendRequest);
            attachementClientRpc.setRole(roleAttachementClientRPC);
            //création du client
            Client client= new Client(visualisation, codeSource, performance, sendRequest);
            rpc.setEntree(roleAttachementClientRPC);
            
            
            //Construction serveur
            //création composant serveur
            //connection manager
            //création des ports
            //liaison entre serveur et ses composants
            Binding bindingServeurES= new Binding ("bindingServeurES");
            Port externalSocket = new Port(bindingServeurES,null);
            
            //liaison entre securityCheck du composant connectionManager et le connecteur clearanceRequest
            Attachement attachementSCCR= new Attachement ("attachementSCCR");
            Port securityCheck= new Port(null,attachementSCCR);
            Role roleAttachementSCCR = new Role(attachementSCCR);
            attachementSCCR.setPort(securityCheck);
            attachementSCCR.setRole(roleAttachementSCCR);
            
            //liaison entre dbQuery du composant connectionManager et le connecteur sqliQuery
            Attachement attachementDBSqliQuery= new Attachement ("attachementDBSqliQuery");
            Port dbQuery=  new Port(null,attachementDBSqliQuery);
            Role roleAttachementDBSqliQuery= new Role(attachementDBSqliQuery);
            attachementDBSqliQuery.setPort(dbQuery);
            attachementDBSqliQuery.setRole(roleAttachementDBSqliQuery);
            
            //création des connecteurs          
            Connecteur clearanceRequest= new Connecteur("clearanceRequest");
            clearanceRequest.setEntree(roleAttachementSCCR);
            Connecteur sqliQuery = new Connecteur("sqliQuery");
            sqliQuery.setEntree(roleAttachementDBSqliQuery);
            
            //création du composant connectionManager
            ConnectionManager connectionManager = new ConnectionManager(externalSocket, securityCheck, dbQuery);
            
            //liaison entre le port securityAut du composant securityManager et le connecteur clearanceRequest
            Attachement attachementSACR= new Attachement ("attachementSACR");
            Port securityAut= new Port(null,attachementSACR);
            Role roleAttachementSACR = new Role(attachementSACR);
            attachementSACR.setPort(securityAut);
            attachementSACR.setRole(roleAttachementSACR);
            
            //liaison entre cQuery du composant securityManager et le connecteur securityQuery
            Attachement attachementCQSQ= new Attachement ("attachementCQSQ");
            Port cQuery= new Port(null,attachementCQSQ);
            Role roleAttachementCQSQ = new Role(attachementCQSQ);
            attachementCQSQ.setPort(cQuery);
            attachementCQSQ.setRole(roleAttachementCQSQ);

            //création de securityQuery
            Connecteur securityQuery= new Connecteur("securityQuery");
            securityQuery.setEntree(roleAttachementCQSQ);
            clearanceRequest.setSortie(roleAttachementSACR);
            
            //création du composant securityManager
            SecurityManagerProjet securityManager=new SecurityManagerProjet(cQuery,securityAut);
            
            //liaison entre le port queryInt du composant dataBase et du connecteur sqliQuery
            Attachement attachementQISqliQuery= new Attachement ("attachementQISqliQuery");
            Port queryInt= new Port(null,attachementQISqliQuery);
            Role roleAttachementQISqliQUery = new Role(attachementQISqliQuery);
            attachementQISqliQuery.setPort(queryInt);
            attachementQISqliQuery.setRole(roleAttachementQISqliQUery);
            sqliQuery.setSortie(roleAttachementQISqliQUery);
            
            //liaison entre le port securityManagement du composant dataBase et le connecteur securityQuery
            Attachement attachementSMSQ= new Attachement ("attachementSMSQ");
            Port securityManagement= new Port(null,attachementSMSQ);
            Role roleAttachementSMSQ = new Role(attachementSMSQ);
            attachementSMSQ.setPort(securityManagement);
            attachementSMSQ.setRole(roleAttachementSMSQ);
            securityQuery.setSortie(roleAttachementSMSQ);
            
            //création du composant database
            Database database= new Database(queryInt, securityManagement);
            
            //création Port receiveRequest
            Attachement attachementRpcRR= new Attachement ("attachementRpcRR");
            Port receiveRequest= new Port(null,attachementRpcRR);
            Role roleAttachementRpcRR = new Role(attachementRpcRR);
            attachementRpcRR.setPort(receiveRequest);
            attachementRpcRR.setRole(roleAttachementRpcRR);
            rpc.setSortie(roleAttachementRpcRR);
            
            //création du serveur
            Serveur serveur= new Serveur(connectionManager, securityManager, database, receiveRequest);
            serveur.initConfiguration();
            
            //création systemConfiguration
            SystemCS systemCs= new SystemCS(client, serveur);
            systemCs.initConfiguration();
	}

}
