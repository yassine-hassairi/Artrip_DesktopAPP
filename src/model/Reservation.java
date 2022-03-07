/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class Reservation {
    
    private int id,idHebergement,idparticipon;
    
    private String date;
    public static int nbrePlace =0; 
     private String nom  , prenom ; 
    private  String mail , repas ; 
    private String liste_hotel; 
    public int prix ; 
    
    
    private int num_tel; 
    
    
    
    
    

    public Reservation() {
    }

    public Reservation(int id, int idHebergement, int idparticipon, String date, String nom, String prenom, String mail, String repas, String liste_hotel, int prix, int num_tel) {
        this.id = id;
        this.idHebergement = idHebergement;
        this.idparticipon = idparticipon;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.repas = repas;
        this.liste_hotel = liste_hotel;
        this.prix = prix;
        this.num_tel = num_tel;
    }

    public Reservation(int idHebergement, int idparticipon, String date, String nom, String prenom, String mail, String repas, String liste_hotel, int prix, int num_tel) {
        this.idHebergement = idHebergement;
        this.idparticipon = idparticipon;
        this.date = date;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.repas = repas;
        this.liste_hotel = liste_hotel;
        this.prix = prix;
        this.num_tel = num_tel;
    }

    public Reservation(String date, String repas, int prix) {
        this.date = date;
        this.repas = repas;
        this.prix = prix;
    }

   
  

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHebergement() {
        return idHebergement;
    }

    public void setIdHebergement(int idHebergement) {
        this.idHebergement = idHebergement;
    }

    public int getIdparticipon() {
        return idparticipon;
    }

    public void setIdparticipon(int idparticipon) {
        this.idparticipon = idparticipon;
    }

   

   

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static int getNbrePlace() {
        return nbrePlace;
    }

    public static void setNbrePlace(int nbrePlace) {
        Reservation.nbrePlace = nbrePlace;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRepas() {
        return repas;
    }

    public void setRepas(String repas) {
        this.repas = repas;
    }

    public String getListe_hotel() {
        return liste_hotel;
    }

    public void setListe_hotel(String liste_hotel) {
        this.liste_hotel = liste_hotel;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", idHebergement=" + idHebergement + ", idparticipon=" + idparticipon + ", date=" + date + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", repas=" + repas + ", liste_hotel=" + liste_hotel + ", prix=" + prix + ", num_tel=" + num_tel + '}';
    }

    

   
}
  

   

