/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import Service.ServiceHebergement;
import Service.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Hebergement;
import model.Reservation;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ReservartionController implements Initializable {
    

    @FXML
    private TextField nom;


    @FXML
    private TextField txfdat;

    private TextField id;


    private Button suivi;

    @FXML
    private Label list;

    
    @FXML
    private AnchorPane idh;
      @FXML
    private TextField idparticp;
      
        @FXML
    private TextField mail;

    @FXML
    private TextField tel;
    
   @FXML
    private TextField prix;
   
     @FXML
    private TextField repas;
      @FXML
    private TextField prenom;
       @FXML
    private TextField LHotel;
         
    
     
     


  
      
   
    
    
    ServiceReservation r =new ServiceReservation ();
   List<Reservation> Reservation =r.afficher();
    @FXML
    private Label affiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    
        @FXML
      
    void ajouter(ActionEvent event) {
          ServiceReservation r =new ServiceReservation ();
          //INT NHPOT INTEGER PARTINT 
         Reservation re =new Reservation (Integer.parseInt(idh.getText()),Integer.parseInt(idparticp.getText()),nom.getText(),txfdat.getText(),prenom.getText(),mail.getText(),repas.getText(),LHotel.getText(),Integer.parseInt(prix.getText()),Integer.parseInt(tel.getText()));
                                                                  
 if(("".equals(idh.getText()))||("".equals(idparticp.getText()))||("".equals(nom.getText()))||("".equals(txfdat.getText()))||("".equals(prenom.getText()))||("".equals(mail.getText()))||("".equals(repas.getText()))||("".equals(LHotel.getText()))||("".equals(prix.getText()))||("".equals(tel.getText()))) 
     
       
        {
      Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        else{
                
                r.ajouter(re);
    ;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("reservation ajouter ");
        alert.show();
         id.setText("");
         idh.setText("");
         idparticp.setText("");
         txfdat.setText("");
         nom.setText("");
         prenom.setText("");
         mail.setText("");
         tel.setText("");
       
         LHotel.setText("");
         prix.setText("");
         
         
         
         
         
       
        
        
        
        
        
        
        
       
        }
       
       
    }   
    
        void pagemodif(ActionEvent event) {

    }

  
    void pagesuivi (ActionEvent event) throws IOException {
    Parent root = FXMLLoader .load(getClass().getResource("/view/Reservation.fxml"));
    Stage window = (Stage) suivi.getScene().getWindow();
    window.setScene(new Scene(root));
     }
}


