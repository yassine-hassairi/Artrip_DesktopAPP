/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.model;

//import java.sql.Date;

/**
 *
 * @author IMEN
 */
public class Hebergement {
    
    private int id,nbr_ch;
    private String nom,adresse,type,type_ch;

    public Hebergement() {
    }

    public Hebergement(int id, String nom, String adresse, String type,int nbr_ch, String type_ch) {
        this.id = id;
        this.nbr_ch = nbr_ch;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.type_ch = type_ch;
    }

    public Hebergement(String nom, String adresse, String type,int nbr_ch, String type_ch) {
        this.nbr_ch = nbr_ch;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.type_ch = type_ch;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbr_ch() {
        return nbr_ch;
    }

    public void setNbr_ch(int nbr_ch) {
        this.nbr_ch = nbr_ch;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_ch() {
        return type_ch;
    }

    public void setType_ch(String type_ch) {
        this.type_ch = type_ch;
    }

    

    @Override
    public String toString() {
        return "Hebergement{" + "nbr_ch=" + nbr_ch + ", nom=" + nom + ", adresse=" + adresse + ", type=" + type + ", type_ch=" + type_ch + '}';
    }
    
}
