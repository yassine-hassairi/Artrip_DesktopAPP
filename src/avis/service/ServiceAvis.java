/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avis.service;

import avis.entities.Avis;
import gestionutilisateur1.utils.MyConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author IMEN
 */
public class ServiceAvis implements IService <Avis>{
     Connection cnx;

    public ServiceAvis() {
        cnx=MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Avis d) {
         PreparedStatement pst;
        
           
            try{
                
            String sql = "INSERT INTO `avis`( `commentaire`) VALUES ('"+d.getCommentaire()+"')";
            Statement stm =cnx.createStatement();
           stm.executeUpdate(sql);
         
            
 } catch (Exception ex) {
                Logger.getLogger(Avis.class.getName()).log(Level.SEVERE, null, ex);
            }  
    
    }

    @Override
    public List<Avis> affcher() {
         return null;
        
    }

    @Override
    public void modifier(Avis d) {

    }

    @Override
    public void supprimer(int t) {
        
    }
    
}
