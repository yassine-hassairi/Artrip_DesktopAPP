/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Jnounou
 */
public class UserController implements Initializable {

    @FXML
    private JFXButton btnProduct;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private JFXButton btnEvent;
    @FXML
    private JFXButton btnHotel;
    @FXML
    private JFXButton btnClaim;
    @FXML
    private JFXButton btnrate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Product(ActionEvent event) {
        btnProduct.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../Produit/GUI/Panier.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
        @FXML
    private void Event(ActionEvent event) {
      btnEvent.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../event/view/AfficheActivit.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Hotel(ActionEvent event) {
    }

    @FXML
    private void Claim(ActionEvent event) {
        btnClaim.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../claim/view/Reclamationfxml.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Logout(ActionEvent event) {
                btnLogout.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/gestionutilisateur1/GUI/Authentification.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void rateUs(ActionEvent event) {
        btnrate.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/avis/view/Ajouter.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
}
