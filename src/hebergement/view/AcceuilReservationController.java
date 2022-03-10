/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class AcceuilReservationController implements Initializable {

    @FXML
    private Button modifi1;
    @FXML
    private Button suivi;
    @FXML
    private Label list;
    @FXML
    private Button Ajouter;
    @FXML
    private Button ajouter;
    @FXML
    private Button add;
    @FXML
    private Button add2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pagemodif(ActionEvent event) {
    }

    @FXML
    private void pagesuivi(ActionEvent event) {
    }

    @FXML
    private void addReserv3(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Reservation.fxml"));
    Stage window = (Stage) ajouter.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
    }

    @FXML
    private void addReserv1(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Reservation.fxml"));
    Stage window = (Stage) ajouter.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
    }

    @FXML
    private void addReserv4(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Reservation.fxml"));
    Stage window = (Stage) ajouter.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
    }

    @FXML
    private void addReserv2(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Reservation.fxml"));
    Stage window = (Stage) ajouter.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
    }
    
}
