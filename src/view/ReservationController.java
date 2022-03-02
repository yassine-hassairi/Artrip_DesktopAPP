/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceEvenements;
import Service.ServiceReservationEven;
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
import javafx.stage.Stage;
import model.Evenements;
import model.ReservationEven;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class ReservationController implements Initializable {
   

    @FXML
    private TextField tfli;

    @FXML
    private TextField tfdesc;

    @FXML
    private TextField txtIm;

    @FXML
    private TextField txfdat;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button modifi1;

    @FXML
    private Button suivi;

    @FXML
    private Label list;

    @FXML
    private Button sh;

    @FXML
    private Label aff;
    
    
      ServiceReservationEven r =new ServiceReservationEven ();
   List<ReservationEven> Reservation =r.afficher();

    /**
     * Initializes the controller class.
     */
       // List<Evenements> evenements  ev = new  evenements();
       // List<Evenements> evenements =ev.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     @FXML
    void show(ActionEvent event) {
         ServiceReservationEven r =new ServiceReservationEven ();
          aff.setText(r.afficher().toString());
    }
    
  
    @FXML
      
    void addReserv(ActionEvent event) {
          ServiceReservationEven r =new ServiceReservationEven ();
          ReservationEven re =new ReservationEven (Integer.parseInt(tfTitle.getText()),tfdesc.getText(),Integer.parseInt(tfli.getText()),txtIm.getText(),txfdat.getText());
        

     
       if(("".equals(tfTitle.getText()))||("".equals(tfdesc.getText()))||("".equals(tfli.getText()))||("".equals(txtIm.getText()))||("".equals(txfdat.getText()))) 
        {
      Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        else{
         r.ajouter(re);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Activité is added successfully!");
        alert.show();
        tfTitle.setText("");
        tfli.setText("");
        tfdesc.setText("");
        txtIm.setText("");
        txfdat.setText("");
        
        };
    

    
    }
    @FXML
    void pagemodif(ActionEvent event) {

    }

  

 

    @FXML
    
     void pagesuivi (ActionEvent event) throws IOException {
Parent root = FXMLLoader .load(getClass().getResource("/view/Suivi.fxml"));
    Stage window = (Stage) suivi.getScene().getWindow();
    window.setScene(new Scene(root));
    


  

     }
}

