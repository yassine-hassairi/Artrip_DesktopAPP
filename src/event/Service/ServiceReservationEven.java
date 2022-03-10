/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import event.model.ReservationEven;
import gestionutilisateur1.utils.MyConnexion;


/**
 *
 * @author Sarra
 */
public class ServiceReservationEven implements IService<ReservationEven> {

    private Connection cnx;

    public ServiceReservationEven() {
        cnx = MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(ReservationEven d) {
        try {
            String querry = "INSERT INTO `reservationeven`( `idEvenement`, `nompartici`,`type`,`lieu`, `idParticipon`, `nomEvenement`, `Date`) VALUES ('" + d.getIdEvenement () + "','" + d.getNomPartici()+ "','"+ d.getType()+"','"+ d.getLieu()+"','"+ d.getIdparticipon()+ "','" +d.getNomEvenement()+ "','" +d.getDate()+ "')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ReservationEven> afficher() {
    
        List<ReservationEven> reservationEven = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT  `nompartici`,`type`,`lieu`,`nomEvenement`, `Date` FROM `reservationeven` where `Etat`=" + 0 ;

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                ReservationEven r = new ReservationEven();
                r.setNomPartici(rs.getString("nompartici"));
                r.setType(rs.getString("type"));
                  r.setLieu(rs.getString("lieu"));
                   
                      r.setNomEvenement(rs.getString("nomEvenement"));
                r.setDate(rs.getDate("Date"));              

               reservationEven.add(r);
               
            } 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }

        return reservationEven;
    }
    
      public List<ReservationEven> afficher2(){
         List<ReservationEven> reservationEven = new ArrayList();
      
         
        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM reservationeven INNER JOIN evenement ON reservationeven.idEvenement  = reservationeven.id ";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                ReservationEven r = new ReservationEven();
                 r.setId(rs.getInt("reservationeven.id"));
                  r.setIdEvenement(rs.getInt("reservationeven.idEvenement"));
                r.setNomPartici(rs.getString("reservationeven.nompartici"));
                r.setType(rs.getString("reservationeven.type"));
                  r.setLieu(rs.getString("reservationeven.lieu"));
                   
                    r.setNomEvenement(rs.getString("reservationeven.nomEvenement"));
                r.setDate(rs.getDate("reservationeven.Date"));    
                  reservationEven.add(r);
            } 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }

        return reservationEven;
    }
       
    

    @Override
    public void modifer(ReservationEven d) {
             try {
            String querry = "UPDATE `reservationeven` SET `idEvenement`='" + d.getIdEvenement()+ "',`nomPartici`='" + d.getNomPartici()+"',`type`='" + d.getType()+"',`lieu`='" + d.getLieu()+  "'`idparticipon`='" + d.getIdparticipon()+ "',`nomEvenement`='" + d.getNomEvenement()+ "',`Date`='" + d.getDate() +  "' WHERE `id`='" + d.getId() +  "'";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("reservationeven modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }}

    @Override
    public void supprimer(int t) {
        PreparedStatement ps;

        try {
            String querry = "UPDATE `reservationeven` SET `Etat`= 1  WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("reservationeven deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public List<ReservationEven> findByNomE(String NomEvenement) {
           List<ReservationEven> reservationEven  = afficher();
        List<ReservationEven>resultat = reservationEven.stream().filter(ReservationEven -> NomEvenement.equals(ReservationEven.getNomEvenement())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }
    public List<ReservationEven> findBylieu(String Lieu) {
           List<ReservationEven> reservationEven  = afficher();
        List<ReservationEven>resultat = reservationEven.stream().filter(ReservationEven -> Lieu.equals(ReservationEven.getNomEvenement())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;}
    public List<ReservationEven> findById(int id) {
      List<ReservationEven> reservationEven  = afficher();
        List<ReservationEven> resultat =reservationEven.stream().filter(ReservationEven -> id ==ReservationEven.getId()).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }

    public List<ReservationEven> sortedById() {
     List<ReservationEven> reservationEven  = afficher();
        List<ReservationEven> resultat = reservationEven.stream().sorted(Comparator.comparing(ReservationEven::getId).reversed()).collect(Collectors.toList());;
 

        resultat.forEach(System.out::println);
        return resultat;

    }
    public List<ReservationEven> sortedByNomEvenement() {
     List<ReservationEven> reservationEven  = afficher();
       
 
   List<ReservationEven> resultat=reservationEven.stream().sorted(Comparator.comparing(ReservationEven::getNomEvenement)).collect(Collectors.toList());
        
       
        return resultat;

    }
}
  

