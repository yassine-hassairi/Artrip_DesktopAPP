/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceEvenements;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Evenements;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class AtiviteController implements Initializable {

 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
   
 @FXML
    private Label affiche;

    @FXML
    private Label adem;

    @FXML
    private Label list;

    @FXML
    private Button supprimer;

    @FXML
    private TextField tfli;

    @FXML
    private TextField tfdesc;

    @FXML
    private TextField txtIm;

       @FXML
    private DatePicker txfdat;

    @FXML
    private TextField txtprix;

    @FXML
    private TextField txtty;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button modifi;

    @FXML
    private Button modifi1;

    @FXML
    private ScrollPane afficher;

    @FXML
    private Label Afficher;

  
   ServiceEvenements e =new ServiceEvenements ();
   List<Evenements> evenement =e.afficher();
   
   
 
   
    @FXML
  void addArticle(ActionEvent event) {
         ServiceEvenements e =new ServiceEvenements ();
           Date date= java.sql.Date.valueOf(this.txfdat.getValue());
   Evenements ev =new Evenements(tfTitle.getText(),tfli.getText(),tfdesc.getText(),txtIm.getText(),txtty.getText(),java.sql.Date.valueOf(this.txfdat.getValue()),txtprix.getText());
        if(("".equals(tfTitle.getText()))||("".equals(tfli.getText()))||("".equals(tfdesc.getText()))||("".equals(txtIm.getText()))||("".equals(txtty.getText()))||("".equals(java.sql.Date.valueOf(this.txfdat.getValue())))||("".equals(txtprix.getText()))) 
        {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        
        else{
         e.ajouter(ev);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Activité is added successfully!");
        alert.show();
        tfTitle.setText("");
        tfli.setText("");
        tfdesc.setText("");
        txtIm.setText("");
        txtty.setText("");
         
                    
        txtprix.setText("");
        }
    

    }
  @FXML
    void afficherl(ActionEvent event) throws IOException {

    
       
            ServiceEvenements e =new ServiceEvenements ();
           Afficher.setText(e.afficher().toString());
           //for (int i = 0; i < bb.afficher().size(); i++){
               
           //}

    }

    @FXML

      void pagemodif(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/view/Modifier.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
 
        
    
    }
        @FXML

  
      void pagesupprimer(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("/view/Supprimer.fxml"));
    Stage window = (Stage) supprimer.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("supprimer Activite");

    }

   

 





}
    
    

