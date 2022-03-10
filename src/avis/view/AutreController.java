/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avis.view;

import avis.entities.Avis;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import avis.service.ServiceAvis;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class AutreController implements Initializable {
    @FXML
    private Button Retour;

    @FXML
    private Button tfajouter;

    @FXML
    private TextField tfprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML
    void goback(ActionEvent event) {
   Retour.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/view/User.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void modifierlv(ActionEvent event) throws IOException {
        ServiceAvis e =new ServiceAvis ();
   Avis ev =new Avis (tfprenom.getText());
        if("".equals(tfprenom.getText()))
        {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        
        else{
         e.ajouter(ev);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Votre commentaire a été ajouté avec succés!");
        alert.show();
        tfprenom.setText(""); 
    }
}}
