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
public class Hebergement {
    private int id;
    private String nom;
     private String adresse;
      private String type;
       private int nbre_chambre;
        private String type_chambre;

    public Hebergement() {
    }

    public Hebergement(int id, String nom, String adresse, String type, int nbre_chambre, String type_chambre) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbre_chambre = nbre_chambre;
        this.type_chambre = type_chambre;
    }

    public Hebergement(String nom, String adresse, String type, int nbre_chambre, String type_chambre) {
        this.nom = nom;
        this.adresse = adresse;
        this.type = type;
        this.nbre_chambre = nbre_chambre;
        this.type_chambre = type_chambre;
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

    public int getNbre_chambre() {
        return nbre_chambre;
    }

    public void setNbre_chambre(int nbre_chambre) {
        this.nbre_chambre = nbre_chambre;
    }

    public String getType_chambre() {
        return type_chambre;
    }

    public void setType_chambre(String type_chambre) {
        this.type_chambre = type_chambre;
    }

    @Override
    public String toString() {
        return "Hebergement{" + "id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", type=" + type + ", nbre_chambre=" + nbre_chambre + ", type_chambre=" + type_chambre + '}';
    }
    
    
    
}
