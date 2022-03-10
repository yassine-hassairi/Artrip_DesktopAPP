/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.view;

import event.Service.ServiceEvenements;
import java.io.File;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import event.model.Evenements;
import event.model.Pdf;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class AtiviteController implements Initializable {
    
    

    @FXML
    private AnchorPane anchorPane;
 


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
    
    @FXML
    private Button btnHome;
    

  
   ServiceEvenements e =new ServiceEvenements ();
   List<Evenements> evenement =e.afficher();
  
    @FXML
    private Button pdf;
   
   
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }   
   

 
   
    @FXML
  void addArticle(ActionEvent event) {
         ServiceEvenements e =new ServiceEvenements ();
           Date date= java.sql.Date.valueOf(this.txfdat.getValue());
   
   Evenements ev =new Evenements(tfTitle.getText(),tfli.getText(),tfdesc.getText(),txtIm.getText(),txtty.getText(),java.sql.Date.valueOf(this.txfdat.getValue()),txtprix.getText());
        if(("".equals(tfTitle.getText()))||("".equals(tfli.getText()))||("".equals(tfdesc.getText()))||("".equals(txtIm.getText()))||("".equals(txtty.getText()))||("".equals(java.sql.Date.valueOf(this.txfdat.getValue())))||("".equals(txtprix.getText()))) 
        {
     Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
       alert1.setContentText("Please added successfully!");
        alert1.show();}
        
        else{
            
         e.ajouter(ev);
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Activité is added successfully!");
    
       alert.showAndWait();
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
    Parent root = FXMLLoader.load(getClass().getResource("/event/view/Modifier.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Activite");
 
        
    
    }
        @FXML
      void pagesupprimer(ActionEvent event) throws IOException {
     supprimer.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/event/view/Supprimer.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void addimage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
Stage stage = (Stage)anchorPane.getScene().getWindow();
        File file = fileChooser.showOpenDialog(stage);
 if(file != null){
            txtIm.setText(file.getName());
        }
    }
    
    @FXML
    void goBack(ActionEvent event) {
        btnHome.getScene().getWindow().hide();
        try {
            Stage stage = new Stage();
            stage.setTitle("");
            Parent root = FXMLLoader.load(getClass().getResource("/view/DashboardAdmin.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void pdf(ActionEvent event) {
        Pdf pd=new Pdf();
        try{
        pd.GeneratePdf("list of Events");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceEvenements.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
   







   

