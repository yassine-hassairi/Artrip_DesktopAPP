/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceReservation;
import Utils.Connexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Reservation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierReseController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       @FXML
    private TextField DateR;

    @FXML
    private TextField pri;

    private TextField repas;
      @FXML
    private ComboBox<String> list;
       Connection cnx;
    ObservableList options = FXCollections.observableArrayList();
    @FXML
    private Button affiche;


    @FXML
    void ModifierRese(ActionEvent event) {
        
        
        
       ServiceReservation r =new ServiceReservation ();
        Reservation re =new Reservation(   DateR.getText(),repas.getText(),Integer.parseInt(pri.getText())    );
        r.modifer(re);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitation ");
        alert.setContentText("Votre reservation a ete modifieé ");
        alert.show();
        
        
    }
    
    public void list(){
    
        
       ServiceReservation r =new ServiceReservation ();
       affiche.setText(r.afficher().toString());
              
    }
               
        
     
       




        






    
        
        
        
        
        
    
    public void fillcombo()
    {
        try {
         
          cnx = Connexion.getInstance().getCnx();
          
            String querry = "SELECT * FROM `reservation`";
            PreparedStatement ps = cnx.prepareStatement(querry);
            ResultSet rs = ps.executeQuery(querry);
            while (rs.next()) {
             
              options.add(rs.getString("id"));
              
                

            }
            
        } catch (SQLException ex) {
            
           
        }
    }
          @FXML
    void getvalue(ActionEvent event) {
        
        
         try {
            int value = Integer.parseInt(list.getValue());
           // LocalDate dt = DateR.valueOf(DateR.getvalue());
            System.out.println(value);
            String querry = "select * from `reservation` where id  = " + value;
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
            
               
               
               DateR.setText(rs.getString("date"));
               pri.setText(rs.getString("prix"));
                  }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierReseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
        
          @FXML
    void Afficher(ActionEvent event) {
        
         ServiceReservation r =new ServiceReservation ();
        affiche.setText(r.afficher().toString());

    }
        
        
           
        
          @Override
    public void initialize(URL url, ResourceBundle rb) {
     
       
        fillcombo();
        list();
        
        
    }}   
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    
        
        
    
        
     

        
        
        
        
        
        

    
    
               
               
               
               
               
               
               
               
               
               
               
               
               
               

         
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
     
    
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
