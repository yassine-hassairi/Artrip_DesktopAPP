/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
//import model.ReservationEven;
import Utils.Connexion;
import model.Reservation;

/**
 *
 * @author ASUS
 */
public class ServiceReservation  implements IService<Reservation>{
    
     private Connection cnx;
    
        public ServiceReservation() {
        cnx = Connexion.getInstance().getCnx();
    }

    public void ajouter(Reservation d) {
        try {
            String querry = "INSERT INTO `reservation`( `idHebergement`, `idparticipon`,  `date`, `nom`	,`prenom`,` mail `,`num_tel`, `repas`,`liste_hotel`,`prix`,) VALUES ('" + d.getIdHebergement() + "','" + d.getIdparticipon()+ "','"  +d.getDate()+ "','" +d.getNom()+"','"+d.getPrenom()+"','"+d.getMail()+"','"+d.getNum_tel()+"','"+d.getRepas()+"','"+d.getListe_hotel()+"','"+d.getPrix()+"')}";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
 @Override
    public List<Reservation> afficher() {
    
        List<Reservation> reservation = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `reservation`";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId(rs.getInt("id"));
                r.setIdHebergement(rs.getInt("idHebergement"));
                r.setIdparticipon(rs.getInt("nomPartici"));
                
                 r.setDate(rs.getString("date"));  
                r.setNom(rs.getString("nom"));
                
                 r.setPrenom(rs.getString("prenom"));
                 
                   r.setMail(rs.getString("mail"));
                   r.setNum_tel (rs.getInt("num_tel"));
                   r.setRepas(rs.getString ("repas"));
                   r.setListe_hotel(rs.getString("liste_hotel"));
                      r.setPrix(rs.getInt ("prix "));
                   
                   
                  
                   
                   
                   
                 
                 reservation.add(r);
                 
              
               
                          

            
            
               
            } 

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }

        return reservation;
    }
 @Override
    public void modifer(Reservation d) {
             try {
            String querry = "UPDATE `reservation` SET `	idHebergement`='" + d.getIdHebergement()+ "',`	idparticipon`='" + d.getIdparticipon()+ "', date`='" + d.getDate()+ "',`nom`='" + d.getNom() + "',`prenom`='" + d.getPrenom() + "',`mail`='" + d.getMail() + "',`num_tel`='" + d.getNum_tel() + "',`repas`='" + d.getRepas() + "',`liste_hotel	`='" + d.getListe_hotel() + "',`prix`='" + d.getPrix() +  "' WHERE `id`='" + d.getId() +  "'";
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
            String querry = "UPDATE `reservation` SET `Etat`= 1  WHERE `id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("votre reservation a ete supprimer ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}





