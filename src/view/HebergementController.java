/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceHebergement;
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
import javafx.stage.StageStyle;
import model.Hebergement;

/**
 * FXML Controller class
 *
 * @author ASUS
 */



public class HebergementController implements Initializable {
    

  
    @FXML
    private TextField tftitre;

    @FXML
    private TextField Adrestx;
    

    @FXML
    private TextField TypeTx;

    @FXML
    private TextField nbrch;

    @FXML
    private TextField typecham;

    @FXML
    private Button supprime;

    private Button modifi;

    @FXML
    private Label Afficher;
    @FXML
    private Button Retour;


    


   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
    @FXML
    void back(ActionEvent event)  {
          /*Parent root = FXMLLoader .load(getClass().getResource("/view/Modifier.fxml"));
          Stage window = (Stage) Retour.getScene().getWindow();
          window.setScene(new Scene(root));*/
          try {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Modifier.fxml"));
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.initStyle(StageStyle.UNDECORATED);
        window.show();
          
    
        }catch (IOException e)
        {
           e.printStackTrace(); 
          
          }
  

    }
    
    
    
    
     @FXML
    void addArticle(ActionEvent event) {
        ServiceHebergement h =new ServiceHebergement();
         
        Hebergement he =new Hebergement(tftitre.getText(),Adrestx.getText(),TypeTx.getText(),Integer.parseInt(nbrch.getText()),typecham.getText());
        h.ajouter(he);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Activité is added successfully!");
        alert.show();
       tftitre.setText("");
       Adrestx.setText("");
       TypeTx.setText("");
       nbrch.setText("");
       typecham.setText("");
               
    }

    @FXML
 
void afficherl(ActionEvent event) throws IOException {
      
            ServiceHebergement e =new ServiceHebergement();
                Afficher.setText(e.afficher().toString());
    }

    @FXML
    void pagesupp(ActionEvent event) {

    }




}
