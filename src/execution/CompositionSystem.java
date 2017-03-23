package execution;

import M0.Attachement;
import M0.Binding;
import M0.Connecteur;
import M0.Port;
import M0.Propriete;
import M0.Role;
import M0.SystemCS;
import M0.client.Client;
import M0.serveur.ConnectionManager;
import M0.serveur.Database;
import M0.serveur.SecurityManagerProjet;
import M0.serveur.Serveur;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Audrey
 */
public class CompositionSystem {
    
    public final static String NOM_CONFIGURATIONCS = "configurationCS";
    public final static String NOM_SERVEUR = "serveur";
    public final static String NOM_CLIENT = "client";
    public final static String NOM_DATABASE = "database";
    public final static String NOM_CONNECTION_MANAGER = "connectionManager";
    public final static String NOM_SECURITY_MANAGER = "securityManager";
    public final static String NOM_CONNECTEUR_RPC = "connecteurRPC";
    public final static String NOM_PORT_SENDREQUEST = "sendRequest";
    public final static String NOM_PORT_RECEIVEREQUEST = "receiveRequest";
    public final static String NOM_CONNECTEUR_CLEARANCEREQUEST = "clearanceRequest";
    public final static String NOM_CONNECTEUR_SECURITYQUERRY = "securityQuerry";
    public final static String NOM_CONNECTEUR_SQLIQUERRY = "SQLIQuerry";
    public final static String NOM_PORT_SECURITYCHECK = "securityCheck";
    public final static String NOM_PORT_SECURITYAUT = "securityAut";
    public final static String NOM_PORT_CQUERRY = "cQuerry";
    public final static String NOM_PORT_SECURITYMANAGEMENT = "securityManagement";
    public final static String NOM_PORT_QUERYINT = "queryInt";
    public final static String NOM_PORT_DBQUERY = "dbQuery";
    public final static String NOM_PORT_EXTERNALSOCKET = "externalSocket";
    public final static String NOM_PORT_INTERNAL_SERVEUR = "internal serveur";
    public final static String NOM_ATTACHEMENT_CLIENTRPC = "attachementClientRpc";
    public final static String NOM_ATTACHEMENT_RPC_SERVEUR = "AttachementRpcRR";
    public final static String NOM_BINDING_SERVEUR_COMPO = "bindingServeurES";
    public final static String NOM_ATTACHEMENT_CONNECTIONMANAGER_CLEARANCE = "attachementSCCR";
    public final static String NOM_ATTACHEMENT_CLEARANCE_SECURITYMANAGER= "attachementSACR";
    public final static String NOM_ATTACHEMENT_SECURITYMANAGER_SECURITYQUERY = "attachementCQSQ";
    public final static String NOM_ATTACHEMENT_SECURITYQUERY_DB = "attachementSMSQ";
    public final static String NOM_ATTACHEMENT_DB_SQLI = "attachementQISqliQuery";
    public final static String NOM_ATTACHEMENT_SQLI_CONNECTIONMANAGER = "attachementDBSqliQuery";
    
    public static SystemCS construireLeSystem() throws Exception{
            
        //attachement client connecteur rpc    
        Connecteur rpc= new Connecteur (CompositionSystem.NOM_CONNECTEUR_RPC);
        Role roleAttachementClientRPC= new Role(null,rpc,"role"+CompositionSystem.NOM_ATTACHEMENT_CLIENTRPC);
        //instanciation du rpc                   
        rpc.setEntree(roleAttachementClientRPC);


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
        Attachement attachementSACR= new Attachement (CompositionSystem.NOM_ATTACHEMENT_CLEARANCE_SECURITYMANAGER);
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
        SystemCS systemCs= new SystemCS(serveur, CompositionSystem.NOM_CONFIGURATIONCS,rpc);

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
    
    public static Client connecterUnClient(SystemCS scs, String nom) throws Exception{
        //Construction client
        //propriété client
        Propriete visualisation= new Propriete();
        Propriete codeSource= new Propriete();
        Propriete performance= new Propriete();            
        Attachement attachementClientRpc= new Attachement (CompositionSystem.NOM_ATTACHEMENT_CLIENTRPC);            
        Port sendRequest= new Port(null, attachementClientRpc, CompositionSystem.NOM_PORT_SENDREQUEST);
        attachementClientRpc.setPort(sendRequest);            
        attachementClientRpc.setRole(scs.getRPC().getEntree());
        //création du client
        Client client= new Client(visualisation, codeSource, performance, sendRequest,CompositionSystem.NOM_CLIENT);            
        sendRequest.setCompo(client);
        scs.addClient(client);
        scs.getRPC().getEntree().addAttch(attachementClientRpc);
        client.DeterminerObservateur(scs);
        return client;
    }
    
}
