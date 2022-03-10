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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import avis.service.ServiceAvis;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class AjouterController implements Initializable {
    
    
      @FXML
    private Label adem;


    @FXML
    private Label list;

    @FXML
    private Button tfbad;

    @FXML
    private Button tfexcellent;

    @FXML
    private Button tfmidium;

    private Button tfother;
    @FXML
    private Button BtnOther;
    @FXML
    private Button btnRetour;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void addExcellent(ActionEvent event) throws IOException {
        ServiceAvis sa = new ServiceAvis();
        Avis a1 = new Avis();
        a1.setCommentaire("Execellent");
        sa.ajouter(a1);
           Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("Merci pour votre confiance").graphic(null)
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void addMidium(ActionEvent event) {
            ServiceAvis sa = new ServiceAvis();
        Avis a1 = new Avis();
        a1.setCommentaire("Plus au moins");
        sa.ajouter(a1);
            Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("Merci").graphic(null)
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    @FXML
    private void addBad(ActionEvent event) {
        ServiceAvis sa = new ServiceAvis();
        Avis a1 = new Avis();
        a1.setCommentaire("Mediocre");
        sa.ajouter(a1);
            Notifications notificationBuilder = Notifications.create()
        .title("Alert").text("Nous ferons de notre mieux pour améliorer nos services?").graphic(null)
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }
    
        
    
   @FXML
    void addOther(ActionEvent event) {
    BtnOther.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("Modifier Reclamation");
            Parent root = FXMLLoader.load(getClass().getResource("/avis/view/Autre.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    

    }

    @FXML
    private void Retour(ActionEvent event) {
        btnRetour.getScene().getWindow().hide();
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

    
}
