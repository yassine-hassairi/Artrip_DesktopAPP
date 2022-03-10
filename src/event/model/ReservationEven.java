/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.model;

import java.sql.Date;

/**
 *
 * @author Sarra
 */
public class ReservationEven {
    private int id,idEvenement;
    private String  nomPartici;
    private String type;
    private String lieu;

private int idparticipon;
  private String nomEvenement;
 private Date date;



    public static int getNbreParticipon() {
        return nbreParticipon;
    }

    public static void setNbreParticipon(int nbreParticipon) {
        ReservationEven.nbreParticipon = nbreParticipon;
    }

    public ReservationEven(int idEvenement, String nomPartici, String type, String lieu, int idparticipon, String nomEvenement, Date date) {
        this.idEvenement = idEvenement;
        this.nomPartici = nomPartici;
        this.type = type;
        this.lieu = lieu;
        this.idparticipon = idparticipon;
        this.nomEvenement = nomEvenement;
        this.date = date;
    }
 
 public static int nbreParticipon =0; 

   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

  

    public ReservationEven(int id, int idEvenement, String nomPartici, String type, String lieu, int idparticipon, String nomEvenement, Date date) {
        this.id = id;
        this.idEvenement = idEvenement;
        this.nomPartici = nomPartici;
        this.type = type;
        this.lieu = lieu;
       
        this.idparticipon = idparticipon;
        this.nomEvenement = nomEvenement;
        this.date = date;
    }


   

   
    
  
    
    
    
    
    
  
    
    public ReservationEven() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public int getIdparticipon() {
        return idparticipon;
    }

    public void setIdparticipon(int idparticipon) {
        this.idparticipon = idparticipon;
    }

    public String getNomPartici() {
        return nomPartici;
    }

    public void setNomPartici(String nomPartici) {
        this.nomPartici = nomPartici;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ReservationEven{" + "nomPartici=" + nomPartici + ", type=" + type + ", lieu=" + lieu + ", idparticipon=" + idparticipon + ", nomEvenement=" + nomEvenement + ", date=" + date + '}';
    }

   

    


   




    
  

  

 

}    
