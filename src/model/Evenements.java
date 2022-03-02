/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Sarra
 */
public class Evenements {
    private int Id;
    private String Titre,Lieu,Description,Type;
    private   String Image; 
 private String prix;
    //private Etat  Etat ;
    private Date  date; 
    
    public Evenements( String Titre, String Lieu, String Description, String Image, String Type,Date  date,String prix ) {
        this.Id=Titre.length()*Lieu.length()+Description.length();
        this.Titre = Titre;
        this.Lieu = Lieu;
        this.Description = Description;
        this.Image = Image;
        this.Type = Type;
        this.date=date;
        this.prix=prix;
       
        
    }
  

    


    
   

    public Evenements(int Id,String Titre, String Lieu, String Description, String Image, String Type, Date  date,String prix ) {
        this.Id=Id;
        this.Titre = Titre;
        this.Lieu = Lieu;
        this.Description = Description;
        this.Image = Image;
        this.Type = Type;
        this.date=date;
        this.prix=prix;
        
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    

  
 
  

  

  
    public Evenements() {
    }

   

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getLieu() {
        return Lieu;
    }

    public void setLieu(String Lieu) {
        this.Lieu = Lieu;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    

    

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
     @Override
    public String toString() {
        return "Evenements{" + "id=" + Id + ", Titre=" + Titre+ ", Lieu=" + Lieu + ", Description=" + Description + ", Image=" + Image+",Type=" + Type+",Date=" + date+" \n";
    }

   
    
}
