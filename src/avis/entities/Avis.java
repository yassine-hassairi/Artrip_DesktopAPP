/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avis.entities;

/**
 *
 * @author IMEN
 */
public class Avis {
     private int id ;
    private String commentaire;

    public Avis() {
    }

    public Avis(int id, String commentaire) {
        this.id = id;
        this.commentaire = commentaire;
    }

    public Avis(String commentaire) {
        this.commentaire = commentaire;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", commentaire=" + commentaire + '}';
    }
    
    
    
}
