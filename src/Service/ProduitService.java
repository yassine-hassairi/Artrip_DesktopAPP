/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entities.Produit;
import Utils.myConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yassine
 */
public class ProduitService implements IService<Produit>{
   
    Connection cnx = myConnection.getInstance().getCnx();
    
    @Override
    public void ajouter(Produit p){
        String querry ="INSERT INTO `produit`(`nom`, `quantite`, `prix`, `description`, `image`) VALUES ('"+ p.getNom() +"','"+ p.getQuantite()+"','"+ p.getPrix() +"','"+ p.getDescription() +"','"+ p.getImage()+"')"; 

        try {
            Statement stm = cnx.createStatement();
            stm.execute(querry);
            System.out.println("product added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Produit> afficher(){
        List<Produit> produits = new ArrayList<>();
        String querry = "SELECT * FROM `produit` WHERE `etat` = 1";
        try {
            Statement stmt = cnx.createStatement();
            ResultSet result = stmt.executeQuery(querry);

            while(result.next()) {
                produits.add(new Produit(
                        result.getInt("idProduit"),
                        result.getString("nom"),
                        result.getInt("quantite"),
                        result.getFloat("prix"),
                        result.getString("description"),
                        result.getString("image")
                        
                ));
            }
            return produits;
            
           // Debugger.log("INFO: Successfully fetched all users.");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public void modifier(Produit p) {
        String query = "UPDATE produit set  `nom`='"+p.getNom()+"', `quantite`='"+p.getQuantite()+"', `prix`='"+p.getPrix()+"', `description`='"+p.getDescription()+"', `image`='"+p.getImage()+"' where idProduit='"+p.getIdProduit()+"'";
       try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate(query);
            System.out.println("INFO: produit Updated.");
        } catch (SQLException ex) {
        }
    }

    @Override
    public void supprimer(Produit p) {
        String query = "UPDATE produit set  `etat`='"+p.getEtat()+"' where idProduit='"+p.getIdProduit()+"'";
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate(query);
            System.out.println("INFO: Produit Deleted.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerIdP(int value) {
        String query = "UPDATE produit set  `etat`= 0 where idProduit='"+ value +"'";
        try {
            Statement stmt = cnx.createStatement();
            stmt.executeUpdate(query);
            System.out.println("INFO: Produit Deleted.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }    }

  
}
