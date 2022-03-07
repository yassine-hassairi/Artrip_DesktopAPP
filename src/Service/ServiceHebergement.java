/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import model.Hebergement;

/**
 *
 * @author ASUS
 */
public class ServiceHebergement  implements IService<Hebergement>{
    private Connection  cnx;
    public ServiceHebergement (){
         cnx = Connexion.getInstance().getCnx();
    }

     @Override
    public void ajouter(Hebergement h) {
        try {
            String querry = "INSERT INTO `hebergement`(`nom`, `adresse`, `type`, `nbr_chambre`, `type_chambre`) VALUES ('" + h.getNom() + "','" + h.getAdresse() + "','" + h.getType() + "','" + h.getNbre_chambre() + "','" + h.getType_chambre() +"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(querry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Hebergement> afficher() {
        List<Hebergement> hebergements  = new ArrayList();

        try {
            Statement stm = cnx.createStatement();
            String querry = "SELECT * FROM hebergement";

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                Hebergement h = new Hebergement();
                h.setId(rs.getInt("id"));
                h.setNom(rs.getString("nom"));
                h.setAdresse(rs.getString("adresse"));
                h.setType(rs.getString("type"));
                h.setNbre_chambre(rs.getInt("nbr_chambre"));
                h.setType_chambre(rs.getString("type_chambre"));
               

                hebergements.add(h);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        return hebergements;
    }

  
    @Override
    public void supprimer(int t) {
        PreparedStatement ps;

        try {
            String querry = "UPDATE `hebergement` SET `Etat`=1 WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("Hebergement deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void modifer(Hebergement h) {
        try {
            
            String querry = "UPDATE `hebergement` SET `nom`='" +  h.getNom() + "',`adresse`='" + h.getAdresse() + "',`type`='" + h.getType() + "' ,`nbr_chambre`='" + h.getNbre_chambre() + "',`type_chambre`='" + h.getType_chambre() +  "' WHERE `id`='" + h.getId() +  "'";

            Statement ps = cnx.createStatement();
            ps.executeUpdate(querry);
            System.out.println("Hebergement modifier ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("erreur");
        }
    }

    

    public   List<Hebergement> findByLieu(String nom) {
         List<Hebergement> hebergements  = afficher();
         List<Hebergement> resultat = hebergements.stream().filter(hebergement -> nom.equals(hebergement.getNom())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }
    
    
    
    
    public  List<Hebergement> findById(int id) {
       List<Hebergement> hebergements = afficher();
        List<Hebergement> resultat = hebergements.stream().filter(hebergement -> id ==hebergement.getId()).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }

    public List<Hebergement> sortedById() {
         List<Hebergement> hebergements = afficher();
        List<Hebergement>  resultat = hebergements.stream().sorted(Comparator.comparing(Hebergement::getId).reversed()).collect(Collectors.toList());;
 

        resultat.forEach(System.out::println);
        return resultat;

    }
    
    
    
}
