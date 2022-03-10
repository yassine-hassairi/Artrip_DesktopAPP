/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claim.entites;

import java.sql.Date;
import java.sql.Time;
import javafx.scene.image.ImageView;

/**
 *
 * @author IMEN
 */
public class Reclamation {
   private int id;
   private String nom;
   private String prenom;
   private String description;
   private String objet;
   private String email ;
  private int numero_mobile;
  private Date date;

   

    public Reclamation(String nom, String prenom, String description, String objet, int numero_mobile, Date date) {
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.objet = objet;
        
        this.numero_mobile = numero_mobile;
        this.date = date;
    }

    public Reclamation(int id, String nom, String prenom, String description, String objet, String email, int numero_mobile, Date date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.objet = objet;
        this.email = email;
        this.numero_mobile = numero_mobile;
        this.date = date;
    }

    public Reclamation() {
    }

    public Reclamation(int value, String text, String text0, String text1, String text2, int parseInt, Date valueOf) {
        
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero_mobile() {
        return numero_mobile;
    }

    public void setNumero_mobile(int numero_mobile) {
        this.numero_mobile = numero_mobile;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
  

     @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", description=" + description + ", objet=" + objet + ", email=" + email + ", numero_mobile=" + numero_mobile + ", date=" + date + '}';
    }
    
    
    
   
    }

    
