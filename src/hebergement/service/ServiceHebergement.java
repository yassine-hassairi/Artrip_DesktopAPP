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
import hebergement.model.Hebergement;

/**
 *
 * @author IMEN
 */
public class ServiceHebergement implements IService<Hebergement> {

    private Connection cnx;

    public ServiceHebergement() {
        cnx = MyConnexion.getInstance().getCnx();

    
}


   
    @Override
    public void supprimer(int t) {
               PreparedStatement ps;

        try {
            String querry = "UPDATE `hebergement` SET `Etat`= 1  WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("hebergement deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    
    }

   

    @Override
    public void modifer(Hebergement d) {
        try {
            String querry = "UPDATE `hebergement` SET `Nom`='" + d.getNom() + "',`adresse`='" + d.getAdresse()+ "',`nbr_chambre`='" + d.getNbr_ch() +"',`type_chambre`='" + d.getType_ch()+ "',`' WHERE `id`='" + d.getId() +  "'";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("hebergement modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
    }

    @Override
    public List<Hebergement> afficher() {
      List<Hebergement> hebergement = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `hebergement` WHERE `Etat`=" + 0;

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Hebergement e = new Hebergement();
                e.setId(rs.getInt("Id"));
                e.setNom(rs.getString("nom"));
                e.setAdresse(rs.getString("adresse"));
                e.setType(rs.getString("type"));
                e.setNbr_ch(rs.getInt("nbr_chambre"));
                e.setType_ch(rs.getString("type_chambre"));
                
                //e.setEtat( Etat.valueOf(rs.getString("Etat")));
            

                hebergement.add(e);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return hebergement;
    
        
    }

    @Override
    public void ajouter(Hebergement d) {
        
        try {
            String querry = "INSERT INTO `hebergement`(`nom`, `adresse`, `type`, `nbr_chambre`, `type_chambre`) VALUES ('" + d.getNom() + "','" + d.getAdresse() + "','" + d.getType() + "','" + d.getNbr_ch() + "','" + d.getType_ch() + "')";
    Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        }

    public List<Hebergement> sortedById() {

        List<Hebergement> hebergement = afficher();
        List<Hebergement> resultat = hebergement.stream().sorted(Comparator.comparing(Hebergement::getId).reversed()).collect(Collectors.toList());
        return resultat;    }
      public List<Hebergement> findByNom(String Nom) {
           List<Hebergement> reservationEven  = afficher();
        List<Hebergement>resultat = reservationEven.stream().filter(Hebergement -> Nom.equals(Hebergement.getNom())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;}
}