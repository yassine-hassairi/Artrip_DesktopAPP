/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Yassine
 */
public class Produit {
    
    private int idProduit;
    private String nom;
    private int quantite;
    private float prix;
    private String description;
    private String image;
    private  int etat;

    public Produit() {
    }   

    public Produit(int idProduit, String nom, int quantite, float prix, String description, String image, int etat) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.etat = etat;
    }

    public Produit(int idProduit, String nom, int quantite, float prix, String description, String image) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.image = image;
    }

    public Produit(String nom, int quantite, float prix, String description, String image) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.image = image;
    }
    
    

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", description=" + description + ", image=" + image + "\n";
    }
    
    
    
    
}
