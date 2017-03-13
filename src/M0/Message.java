/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package M0;

/**
 *
 * @author Audrey
 */
public class Message {
    private int id;
    private String objet;
    private String contenu;

    public Message(int id, String objet, String contenu) {
        this.id = id;
        this.objet = objet;
        this.contenu = contenu;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
    
    
    
}
