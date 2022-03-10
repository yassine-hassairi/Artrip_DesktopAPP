/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.service;

import gestionutilisateur1.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import hebergement.model.Reservation;


/**
 *
 * @author IMEN
 */
public class ServiceReservation implements IService<Reservation> {

    private Connection cnx;

    public ServiceReservation() {
        cnx = MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reservation d) {
        try {
            String querry = "INSERT INTO `reservation`( `date`, `nom`,`prenom`,`liste_hotel`, `prix`) VALUES ('"+d.getDate()+ "','" + d.getNom()+ "','"+ d.getPrenom()+"','"+ d.getListe_hotel()+"','"+ d.getPrix()+ "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @Override
    public List<Reservation> afficher() {

        List<Reservation> reservationEven = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT  `nom`,`prenom`,`liste_hotel`,`prix`, `date` FROM `reservation` ";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Reservation r = new Reservation();
                
                r.setNom(rs.getString("nom"));
                r.setPrenom(rs.getString("prenom"));
                  r.setListe_hotel(rs.getString("liste_hotel"));
                   
                      r.setPrix(rs.getString("prix"));
                r.setDate(rs.getDate("Date"));              

               reservationEven.add(r);
               
            } 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
        List<Reservation> reservation = null;

        return reservation;
    }

    @Override
    public void modifer(Reservation d) {
            try {
            String querry = "UPDATE `reservation` SET `Date`='" + d.getDate() +"',`nom`='" + d.getNom()+"',`prenom`='" + d.getPrenom()+"',`liste_hotel()`='" + d.getListe_hotel()+  "'`prix`='" + d.getPrix()+ "' WHERE `id`='" + d.getId() + "')";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("reservation modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
        
    }

    @Override
    public void supprimer(int t) {
         PreparedStatement ps;

        try {
            String querry = "UPDATE `reservation` SET `Etat`= 1  WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("reservation deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }
    public List<Reservation> findBynom(String Nom) {
           List<Reservation> reservation  = afficher();
        List<Reservation>resultat = reservation.stream().filter(ReservationEven -> Nom.equals(ReservationEven.getNom())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    
}
    public List<Reservation> sortedById() {
        List<Reservation> evenements = afficher();
        List<Reservation> resultat = evenements.stream().sorted(Comparator.comparing(Reservation::getId).reversed()).collect(Collectors.toList());
        return resultat;

 
    }
}
