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
public class ReservationEven {
    private int id,idEvenement,idparticipon;
    private String nomPartici,nomEvenement;
       private String date;
 public static int nbreParticipon =0; 
    public ReservationEven() {
    }

    public ReservationEven(int idEvenement,  String nomPartici,int idparticipon, String nomEvenement, String date) {
        this.idEvenement = idEvenement;
        this.nomPartici = nomPartici;
        this.idparticipon = idparticipon;
        this.nomEvenement = nomEvenement;
        this.date = date;
        nbreParticipon++;
    }


    public ReservationEven(int id, int idEvenement, int idparticipon, String nomPartici, String nomEvenement, String date) {
        this.id = id;
        this.idEvenement = idEvenement;
        this.idparticipon = idparticipon;
        this.nomPartici = nomPartici;
        this.nomEvenement = nomEvenement;
        this.date = date;
        nbreParticipon++;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static int getNbreParticipon() {
        return nbreParticipon;
    }

    public static void setNbreParticipon(int nbreParticipon) {
        ReservationEven.nbreParticipon = nbreParticipon;
    }

  

  

      @Override
    public String toString() {
        return "ReservationEven{" + "id=" + id + ", idEvenement=" + idEvenement + ", idparticipon=" + idparticipon + ", nomPartici=" + nomPartici + ", nomEvenement=" + nomEvenement + ", date=" + date + '}';
    }

}    
