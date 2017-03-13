
import M0.*;
import M0.client.Client;
import M0.serveur.*;


public class Main_project {
    

            

	public static void main(String[] args) {
		SystemCS sys = construireLeSystem();
                
                
	}
        
        public static SystemCS construireLeSystem(){
            //Construction client
            //propriété client
            Propriete visualisation= new Propriete();
            Propriete codeSource= new Propriete();
            Propriete performance= new Propriete();
            //attachement client connecteur rpc    
            Connecteur rpc= new Connecteur (CompositionSystem.NOM_CONNECTEUR_RPC);
            Attachement attachementClientRpc= new Attachement (CompositionSystem.NOM_ATTACHEMENT_CLIENTRPC);
            Port sendRequest= new Port(null, attachementClientRpc, CompositionSystem.NOM_PORT_SENDREQUEST);
            Role roleAttachementClientRPC= new Role(attachementClientRpc,rpc,"role"+CompositionSystem.NOM_ATTACHEMENT_CLIENTRPC);
            //instanciation du rpc
            attachementClientRpc.setPort(sendRequest);
            attachementClientRpc.setRole(roleAttachementClientRPC);
            //création du client
            Client client= new Client(visualisation, codeSource, performance, sendRequest,CompositionSystem.NOM_CLIENT);
            rpc.setEntree(roleAttachementClientRPC);
            sendRequest.setCompo(client);
            
            
            //Construction serveur
            //création composant serveur
            //connection manager
            //création des ports
            //liaison entre serveur et ses composants            
            Port externalSocket = new Port(null,null,CompositionSystem.NOM_PORT_EXTERNALSOCKET);
            Port internalServeur = new Port(null,null, CompositionSystem.NOM_PORT_INTERNAL_SERVEUR);
            Binding bindingServeurES= new Binding (CompositionSystem.NOM_BINDING_SERVEUR_COMPO,internalServeur, externalSocket);            
            externalSocket.setBind(bindingServeurES);
            internalServeur.setBind(bindingServeurES);
            //liaison entre securityCheck du composant connectionManager et le connecteur clearanceRequest
            Connecteur clearanceRequest= new Connecteur(CompositionSystem.NOM_CONNECTEUR_CLEARANCEREQUEST);
            Attachement attachementSCCR= new Attachement (CompositionSystem.NOM_ATTACHEMENT_CONNECTIONMANAGER_CLEARANCE);
            Port securityCheck= new Port(null,attachementSCCR,CompositionSystem.NOM_PORT_SECURITYCHECK);
            Role roleAttachementSCCR = new Role(attachementSCCR,clearanceRequest,"role"+CompositionSystem.NOM_ATTACHEMENT_CLEARANCE_SECURITYMANAGER);
            attachementSCCR.setPort(securityCheck);
            attachementSCCR.setRole(roleAttachementSCCR);
            
            //liaison entre dbQuery du composant connectionManager et le connecteur sqliQuery            
            Connecteur sqliQuery = new Connecteur(CompositionSystem.NOM_CONNECTEUR_SQLIQUERRY);
            Attachement attachementDBSqliQuery= new Attachement (CompositionSystem.NOM_ATTACHEMENT_SQLI_CONNECTIONMANAGER);
            Port dbQuery=  new Port(null,attachementDBSqliQuery,CompositionSystem.NOM_PORT_DBQUERY);
            Role roleAttachementDBSqliQuery= new Role(attachementDBSqliQuery,sqliQuery,"role"+CompositionSystem.NOM_ATTACHEMENT_SQLI_CONNECTIONMANAGER);
            attachementDBSqliQuery.setPort(dbQuery);
            attachementDBSqliQuery.setRole(roleAttachementDBSqliQuery);
            
            //liaison des connecteurs          
            
            clearanceRequest.setEntree(roleAttachementSCCR);
            sqliQuery.setEntree(roleAttachementDBSqliQuery);
            
            //création du composant connectionManager
            ConnectionManager connectionManager = new ConnectionManager(externalSocket, securityCheck, dbQuery, CompositionSystem.NOM_CONNECTION_MANAGER);
            externalSocket.setCompo(connectionManager);
            securityCheck.setCompo(connectionManager);
            dbQuery.setCompo(connectionManager);
            //liaison entre le port securityAut du composant securityManager et le connecteur clearanceRequest
            Attachement attachementSACR= new Attachement (CompositionSystem.NOM_ATTACHEMENT_CONNECTIONMANAGER_CLEARANCE);
            Port securityAut= new Port(null,attachementSACR,CompositionSystem.NOM_PORT_SECURITYAUT);
            Role roleAttachementSACR = new Role(attachementSACR, clearanceRequest,"role"+CompositionSystem.NOM_ATTACHEMENT_CONNECTIONMANAGER_CLEARANCE);
            attachementSACR.setPort(securityAut);
            attachementSACR.setRole(roleAttachementSACR);
                        
            //création de securityQuery
            Connecteur securityQuery= new Connecteur(CompositionSystem.NOM_CONNECTEUR_SECURITYQUERRY);
            
            //liaison entre cQuery du composant securityManager et le connecteur securityQuery
            Attachement attachementCQSQ= new Attachement (CompositionSystem.NOM_ATTACHEMENT_SECURITYMANAGER_SECURITYQUERY);
            Port cQuery= new Port(null,attachementCQSQ,CompositionSystem.NOM_PORT_CQUERRY);
            Role roleAttachementCQSQ = new Role(attachementCQSQ,securityQuery,"role"+ CompositionSystem.NOM_ATTACHEMENT_SECURITYMANAGER_SECURITYQUERY);
            attachementCQSQ.setPort(cQuery);
            attachementCQSQ.setRole(roleAttachementCQSQ);

            
            securityQuery.setEntree(roleAttachementCQSQ);
            clearanceRequest.setSortie(roleAttachementSACR);
            
            //création du composant securityManager
            SecurityManagerProjet securityManager=new SecurityManagerProjet(cQuery,securityAut, CompositionSystem.NOM_SECURITY_MANAGER);
            cQuery.setCompo(securityManager);
            securityAut.setCompo(securityManager);
            
            //liaison entre le port queryInt du composant dataBase et du connecteur sqliQuery
            Attachement attachementQISqliQuery= new Attachement (CompositionSystem.NOM_ATTACHEMENT_DB_SQLI);
            Port queryInt= new Port(null,attachementQISqliQuery, CompositionSystem.NOM_PORT_QUERYINT);
            Role roleAttachementQISqliQUery = new Role(attachementQISqliQuery, sqliQuery,"role"+CompositionSystem.NOM_ATTACHEMENT_DB_SQLI);
            attachementQISqliQuery.setPort(queryInt);
            attachementQISqliQuery.setRole(roleAttachementQISqliQUery);
            sqliQuery.setSortie(roleAttachementQISqliQUery);
            
            //liaison entre le port securityManagement du composant dataBase et le connecteur securityQuery
            Attachement attachementSMSQ= new Attachement (CompositionSystem.NOM_ATTACHEMENT_SECURITYQUERY_DB);
            Port securityManagement= new Port(null,attachementSMSQ,CompositionSystem.NOM_PORT_SECURITYMANAGEMENT);
            Role roleAttachementSMSQ = new Role(attachementSMSQ,securityQuery,"role"+CompositionSystem.NOM_ATTACHEMENT_SECURITYQUERY_DB);
            attachementSMSQ.setPort(securityManagement);
            attachementSMSQ.setRole(roleAttachementSMSQ);
            securityQuery.setSortie(roleAttachementSMSQ);
            
            //création du composant database
            Database database= new Database(queryInt, securityManagement, CompositionSystem.NOM_DATABASE);
            queryInt.setCompo(database);
            securityManagement.setCompo(database);
            
            //création Port receiveRequest
            Attachement attachementRpcRR= new Attachement (CompositionSystem.NOM_ATTACHEMENT_RPC_SERVEUR);
            Port receiveRequest= new Port(null,attachementRpcRR, CompositionSystem.NOM_PORT_RECEIVEREQUEST);
            Role roleAttachementRpcRR = new Role(attachementRpcRR,rpc, "role"+CompositionSystem.NOM_ATTACHEMENT_RPC_SERVEUR);
            attachementRpcRR.setPort(receiveRequest);
            attachementRpcRR.setRole(roleAttachementRpcRR);
            rpc.setSortie(roleAttachementRpcRR);
            
            //création du serveur
            Serveur serveur= new Serveur(connectionManager, securityManager, database, receiveRequest,internalServeur, CompositionSystem.NOM_SERVEUR);
            receiveRequest.setCompo(serveur);
            internalServeur.setCompo(serveur);
            
            //création systemConfiguration
            SystemCS systemCs= new SystemCS(client, serveur, CompositionSystem.NOM_CONFIGURATIONCS);
            
            client.DeterminerObservateur(systemCs);
            serveur.DeterminerObservateur(systemCs);
            rpc.DeterminerObservateur(systemCs);
            
            clearanceRequest.DeterminerObservateur(serveur);
            sqliQuery.DeterminerObservateur(serveur);
            securityQuery.DeterminerObservateur(serveur);
            
            connectionManager.DeterminerObservateur(serveur);
            securityManager.DeterminerObservateur(serveur);
            database.DeterminerObservateur(serveur);
            
            
            return systemCs;
        }

}
