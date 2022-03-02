/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Service.IService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import model.Evenements;
import utils.Connexion;


/**
 *
 * @author Sarra
 */
public class ServiceEvenements implements IService<Evenements> {

    private Connection cnx;

    public ServiceEvenements() {
        cnx = Connexion.getInstance().getCnx();

    }

    @Override
    public void ajouter(Evenements d) {
        try {
            String querry = "INSERT INTO `evenement`( `Titre`, `Lieu`, `Description`, `Image`, `Type`, `Date`, `Prix`) VALUES ('" + d.getTitre() + "','" + d.getLieu() + "','" + d.getDescription() + "','" + d.getImage() + "','" + d.getType() + "','" + d.getDate() + "','" + d.getPrix() +"')";
            Statement stm = cnx.createStatement();

            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Evenements> afficher() {
        List<Evenements> evenements = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM `evenement` WHERE `Etat`=" + 0;

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Evenements e = new Evenements();
                e.setId(rs.getInt("Id"));
                e.setTitre(rs.getString("Titre"));
                e.setLieu(rs.getString("lieu"));
                e.setDescription(rs.getString("Description"));
                e.setImage(rs.getString("Image"));
                e.setType(rs.getString("type"));
                e.setDate(rs.getDate("Date"));
                 e.setPrix(rs.getString("Prix"));
                //e.setEtat( Etat.valueOf(rs.getString("Etat")));
            

                evenements.add(e);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return evenements;
    }

    /*public boolean modifer(Evenements d) {
        String querry = " UPDATE `evenement` SET `Titre`='?',`Lieu`='?',`Description`='?',`Image`='?',`Type`='?' WHERE Id= ?";
       

        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

            //ps.setString(1, e.getTitre());
            //ps.setString(2, e.getLieu());
            //ps.setString(3, e.getDescription());
            //ps.setString(4, e.getImage());
           //ps.setString(5, e.getType());
           /// ps.setInt(6, e.getId());

          
            System.out.println("evenement modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }

        return false;
    }*/
    @Override
    public void supprimer(int t) {
        PreparedStatement ps;

        try {
            String querry = "UPDATE `evenement` SET `Etat`=1 WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("evenement deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void modifer(Evenements d) {
        try {
            String querry = "UPDATE `evenement` SET `Titre`='" + d.getTitre() + "',`Lieu`='" + d.getLieu() + "',`Description`='" + d.getDescription() + "',`Image`='" + d.getImage() + "',`Type`='" + d.getType() + "',`Date`='" + d.getDate() + "',`Prix`='" + d.getPrix() + "' WHERE `id`='" + d.getId() +  "'";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("evenement modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
    }

    

    public List<Evenements> findByLieu(String lieu) {
        List<Evenements> evenements = afficher();
        List<Evenements> resultat = evenements.stream().filter(evenement -> lieu.equals(evenement.getLieu())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }
    public List<Evenements> findById(int id) {
        List<Evenements> evenements = afficher();
        List<Evenements> resultat = evenements.stream().filter(evenement -> id ==evenement.getId()).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }

    public List<Evenements> sortedById() {
        List<Evenements> evenements = afficher();
        List<Evenements> resultat = evenements.stream().sorted(Comparator.comparing(Evenements::getId).reversed()).collect(Collectors.toList());;
 

        resultat.forEach(System.out::println);
        return resultat;

    }
    
    

}
