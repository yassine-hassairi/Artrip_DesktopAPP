/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claim.service;

import claim.entites.Reclamation;
import gestionutilisateur1.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author EMNA
 */
public class ServiceReclamation implements IService <Reclamation> {
    Connection cnx;

    public ServiceReclamation() {
        cnx=MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reclamation d) {
 PreparedStatement pst;
        
           
            try{
                
            String sql = "INSERT INTO `reclamation`( `nom`, `prenom`, `description`, `objet`, `numero_mobile`, `date`) VALUES ('"+d.getNom()+"','"+d.getPrenom()+"','"+d.getDescription()+"','"+d.getObjet()+"','"+d.getNumero_mobile()+"','"+d.getDate()+"')";
            Statement stm =cnx.createStatement();
           stm.executeUpdate(sql);
         
            
 } catch (Exception ex) {
                Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
            }    }

    @Override
    public List<Reclamation> affcher() {
        List <Reclamation>reclamations = new ArrayList();
        
            try {
                Statement stm =cnx.createStatement();
        String querry="SELECT * FROM `reclamation` WHERE  `Etat`=" +0;
        
        ResultSet rs= stm.executeQuery(querry);
        while (rs.next()){
            Reclamation r = new Reclamation();
          r.setId(rs.getInt("id"));
          r.setNom(rs.getString("nom"));
          r.setPrenom(rs.getString("prenom"));
          r.setDescription(rs.getString("description"));
          r.setObjet(rs.getString("objet"));
          r.setNumero_mobile(rs.getInt("numero_mobile"));
          
          reclamations.add(r);
            
        }
    
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
            return  reclamations;
    }

    @Override
    public void modifier(Reclamation d) {
        try{
       
            String querry=" UPDATE `reclamation` SET `nom`='"+d.getNom()+"',`prenom`='"+d.getPrenom()+"',`description`='"+d.getDescription()+"',`objet`='"+d.getObjet()+"',`numero_mobile`='"+d.getNumero_mobile()+"',`date`='"+d.getDate()+"'";
             Statement stm =cnx.createStatement();
              stm.executeUpdate(querry);
              System.out.println("reclamation modifiée");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur");
        }
     
    }
    
    

    @Override
    public void supprimer(int t) {
        PreparedStatement ps;

        try {
            String querry = "UPDATE `reclamation` SET `Etat`=1 WHERE `Id`= " + t;

            ps = cnx.prepareStatement(querry);

            ps.execute();

            System.out.println("reclamation deleted");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

      
    }
       public List<Reclamation> findBynom(String nom) {
        List<Reclamation> reclamations = affcher();
        List<Reclamation> resultat = reclamations.stream().filter(reclamation -> nom.equals(reclamation.getNom())).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }
    public List<Reclamation> findById(int id) {
        List<Reclamation> reclamations = affcher();
       List<Reclamation> resultat = reclamations.stream().filter(reclamation -> id ==reclamation.getId()).collect(Collectors.toList());
         resultat.forEach(System.out::println);
        return resultat;
    }

    public List<Reclamation> sortedById() {
    List<Reclamation> reclamations = affcher();
         List<Reclamation>  resultat =reclamations.stream().sorted(Comparator.comparing(Reclamation::getId).reversed()).collect(Collectors.toList());

        resultat.forEach(System.out::println);
        return resultat;

    }

    

 
    
}
