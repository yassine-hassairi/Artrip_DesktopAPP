/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class ReclamationfxmlController implements Initializable {

    @FXML
    private Label affiche;
    @FXML
    private Label adem;
    @FXML
    private Label list;
    @FXML
    private Button supprimer;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfobjet;
    @FXML
    private TextField tftel;
    @FXML
    private TextField tfnom;
    @FXML
    private Button modifi;
    @FXML
    private Button modifi1;
    @FXML
    private ScrollPane afficher;
    /*ServiceReclamation e =new ServiceReclamation ();
   List<Reclamation> reclamation =e.affcher();*/
   
    private Label Afficher;
    @FXML
    private DatePicker txfdat;
    @FXML
    private Label Affcher;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addArticle(ActionEvent event) {
        ServiceReclamation e =new ServiceReclamation ();
           Date date= java.sql.Date.valueOf(this.txfdat.getValue());
   Reclamation ev =new Reclamation (tfnom.getText(),tfprenom.getText(),tfdesc.getText(),tfobjet.getText(),Integer.parseInt(tftel.getText()),java.sql.Date.valueOf(this.txfdat.getValue()));
        if(("".equals(tfnom.getText()))||("".equals(tfprenom.getText()))||("".equals(tfdesc.getText()))||("".equals(tfobjet.getText()))||("".equals(tftel.getText())) ||("".equals(java.sql.Date.valueOf(this.txfdat.getValue()))))
        {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        
        else{
         e.ajouter(ev);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Votre reclamation a été ajoutée avec succés!");
        alert.show();
        tfnom.setText("");
        tfprenom.setText("");
        tfdesc.setText("");
        tfobjet.setText("");
        tftel.setText("");
         
    }
    }

   

 
        

    @FXML
    void afficherl(ActionEvent event) {
        
               
            ServiceReclamation e =new ServiceReclamation ();
           Afficher.setText(e.affcher().toString());
    }

    @FXML
    void pagemodif(ActionEvent event) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("/view/Modifier.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Reclamation");
    
    }

    @FXML
    void pagesupprimer(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/Supprimer.fxml"));
    Stage window = (Stage) supprimer.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("supprimer reclamation");
        
        

    }

}

