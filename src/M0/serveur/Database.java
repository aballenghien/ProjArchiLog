/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M0.serveur;

import M0.basededonnees.Colonne;
import M0.Composant;
import M0.communication.Observable;
import M0.communication.Observateur;
import M0.Port;
import M0.communication.Reponse;
import M0.communication.Requete;
import M0.basededonnees.Table;
import java.util.ArrayList;

/**
 *
 * @author E101746T
 */
public class Database extends Composant {
    
    private Port queryInt;
    private Port securityManagement;
    private ArrayList<Table> lstTables;
    
    public Database(Port queryInt, Port securityManagement, String nom) {
        super(nom);
        genererTables();
        this.queryInt = queryInt;
        this.securityManagement = securityManagement;
        this.getLstSorties().add(this.queryInt);
        this.getLstSorties().add(this.securityManagement);
        
    }
    
    public void repondreRequete(){
        Reponse rep = new Reponse(this.getMessage().getUser(), this.getMessage().getMdp(), this.getMessage().getRequete());
        rep.setAuthentifie(true);
        String [][] resp = new String[1][1];
        if(this.getMessage().getUser().equals("root")){
            resp[0][0] = "audrey";
        }else{
            resp[0][0] = "test";
        }
        rep.setColonneValeur(resp);
        this.reponse = rep;
        
//        Requete req = this.getMessage().getRequete();
//        Table tableATraiter = new Table();
//        for(Table t:this.lstTables){
//            if(t.getNom().equals(req.getTable())){
//                tableATraiter = t;
//            }
//        }
//        
//        for(String s:req.getConditions()){
//            String nomColonne = s.substring(0,s.indexOf("=")-1);
//            String valeur = s.substring(s.indexOf("=")+1);
//            for(Colonne c:)
//        }
    }

    public Port getQueryInt() {
        return queryInt;
    }

    public void setQueryInt(Port queryInt) {
        this.queryInt = queryInt;
    }

    public Port getSecurityManagement() {
        return securityManagement;
    }

    public void setSecurityManagement(Port securityManagement) {
        this.securityManagement = securityManagement;
    }
    
    /**
     * Génération de deux tables pour les base de données
     */
    private void genererTables(){
        this.lstTables = new ArrayList<>();
        Table user = new Table();
        user.setNom("user");
        
        Colonne nom = new Colonne();
        nom.setNom("nom");
        nom.addValeur("root");
        nom.addValeur("audrey");
        
        Colonne mdp = new Colonne();
        mdp.setNom("mdp");
        mdp.addValeur("root");
        mdp.addValeur("audrey");
        
        user.getLstColonnes().add(nom);
        user.getLstColonnes().add(mdp);
        
        Table t1 = new Table();
        t1.setNom("t1");
        
        Colonne c1 = new Colonne();
        c1.setNom("c1");
        c1.addValeur("v1");
        c1.addValeur("v2");
        
        Colonne c2 = new Colonne();
        c2.setNom("c2");
        c2.addValeur("v21");
        c2.addValeur("v22");
        
        t1.addColonne(c1);
        t1.addColonne(c2);
        
        this.lstTables.add(user);
        this.lstTables.add(t1);
        
    }
    
    
    

    
}
