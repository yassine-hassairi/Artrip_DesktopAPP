/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.User;

/**
 * FXML Controller class
 *
 * @author ASUS
 */



public class UserController implements Initializable {
    

    @FXML
    private TextField lnom;

    @FXML
    private TextField ladresse;

    @FXML
    private TextField lemail;

    @FXML
    private TextField telephone;

    @FXML
    private TextField usern;

    @FXML
    private Label Afficher;

    @FXML
    private TextField lprenom;

    @FXML
    private TextField pwd;
    
    @FXML
    private Button button1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    void addUser(ActionEvent event) {
        UserService u =new UserService();
         
        User ur =new User(lnom.getText(),lprenom.getText(),ladresse.getText(),Integer.parseInt(telephone.getText()),lemail.getText(),usern.getText(),pwd.getText());
        u.ajouter(ur);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("utilisateur is added successfully!");
        alert.show();
       lnom.setText("");
       lprenom.setText("");
       ladresse.setText("");
       telephone.setText("");
       lemail.setText("");
       usern.setText("");
       pwd.setText("");
               
    }

@FXML 
void afficherl(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ListUser.fxml"));
            Stage window = (Stage) button1.getScene().getWindow() ;
            window.setScene(new Scene(root));
            window.setTitle("Admin");
    }

    
}
