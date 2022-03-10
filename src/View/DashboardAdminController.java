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
import java.util.logging.Level;
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
 * @author JNOUNOU
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private JFXButton btnUser;
    @FXML
    private JFXButton btnProduct;
    @FXML
    private JFXButton btnEvent;
    @FXML
    private JFXButton btnAccomodation;
    @FXML
    private JFXButton btnClaim;
    @FXML
    private JFXButton btnLogout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void User(ActionEvent event) {
         btnUser.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/gestionutilisateur1/GUI/FXMLadmin.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Product(ActionEvent event) {
        btnProduct.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../Produit/GUI/Produit.fxml"));

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
            Parent root = FXMLLoader.load(getClass().getResource("../event/view/Ativite.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Acommodation(ActionEvent event) {
        btnAccomodation.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../hebergement/view/Hebergement.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void Claim(ActionEvent event) {
                btnClaim.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("../claim/view/ReclamationAdmoin.fxml"));

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
    
}
