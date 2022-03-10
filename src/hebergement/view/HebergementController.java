/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.view;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import hebergement.model.Hebergement;
import hebergement.service.ServiceHebergement;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class HebergementController implements Initializable {
    
    
    @FXML
    private Label affiche;

    @FXML
    private AnchorPane anchorPane;

  /*  @FXML
     private ComboBox<String> list;*/
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();

    @FXML
    private Button modifi;

    @FXML
    private Button modifi1;

    @FXML
    private Button supprimer;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfdesc;

    @FXML
    private TextField tfli;

    @FXML
    private TextField tfnbr;
    
        @FXML
    private TextField tftype;

    /**
     * Initializes the controller class.
     */
          
  ServiceHebergement e =new ServiceHebergement ();
   List<Hebergement> hebergement =e.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
      @FXML
    void Affiche(ActionEvent event) {

        ServiceHebergement e =new ServiceHebergement ();
         affiche.setText(e.afficher().toString());
    }
    
 

    

    @FXML
    void ajoute(ActionEvent event) {
        
                 ServiceHebergement e =new ServiceHebergement ();
                 Hebergement ev =new Hebergement(tfTitle.getText(),tfdesc.getText(),tfnbr.getText(),Integer.parseInt(tftype.getText()),tfli.getText());
        if(("".equals(tfTitle.getText()))||("".equals(tfli.getText()))||("".equals(tfdesc.getText()))||("".equals(tfnbr.getText()))||("".equals(tftype.getText()))) 
        {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
     
        alert1.show();}
        
        else{
            
         e.ajouter(ev);
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Hebergement is added successfully!");
    
       alert.showAndWait();
        alert.show();
        tfTitle.setText("");
        tfli.setText("");
        tfdesc.setText("");
        tftype.setText("");
        tfnbr.setText("");
        }
    

    }

   

    @FXML
    void pagesupprimer(ActionEvent event)  throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/hebergement/view/Supprimer.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Supprimer hebergement");


    }

    @FXML
    private void pagemodif(ActionEvent event) throws IOException {
 
        Parent root = FXMLLoader.load(getClass().getResource("/hebergement/view/Modifier.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier hebergement");

    }
    }
    

