/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.model;

import java.sql.Date;

/**
 *
 * @author IMEN
 */
public class Reservation {
    private int id;
     private Date date;
    private String  nom;
    private String prenom;
    private String liste_hotel;
  private String prix;

    public Reservation(int id, Date date, String nom, String prenom, String liste_hotel, String prix) {
        this.id = id;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.liste_hotel = liste_hotel;
        this.prix = prix;
    }

    public Reservation(Date date, String nom, String prenom, String liste_hotel, String prix) {
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.liste_hotel = liste_hotel;
        this.prix = prix;
    }

    public Reservation() {
    }

    public Reservation(Date valueOf, String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public String getListe_hotel() {
        return liste_hotel;
    }

    public void setListe_hotel(String liste_hotel) {
        this.liste_hotel = liste_hotel;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Reservation{" + "date=" + date + ", nom=" + nom + ", prenom=" + prenom + ", liste_hotel=" + liste_hotel + ", prix=" + prix + '}';
    }
  
  

    
}
