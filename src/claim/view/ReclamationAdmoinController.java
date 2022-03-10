/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claim.view;

import claim.entites.Pdf;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import claim.service.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author EMNA
 */
public class ReclamationAdmoinController implements Initializable {

    @FXML
    private Label affiche;
  
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
   
    @FXML
    private Button pdf;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }       

    @FXML
    void afficherl(ActionEvent event) {
        
               
            ServiceReclamation e =new ServiceReclamation ();
           Afficher.setText(e.affcher().toString());
    }

    @FXML
    void pagemodif(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/claim/view/Modifier.fxml"));
    Stage window = (Stage) modifi.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("Modifier Reclamation");
    
    }

    @FXML
    void pagesupprimer(ActionEvent event) throws IOException {
        
    Parent root = FXMLLoader.load(getClass().getResource("/claim/view/Supprimer.fxml"));
    Stage window = (Stage) supprimer.getScene().getWindow();
    window.setScene(new Scene(root));
    window.setTitle("supprimer reclamation");

    }

   @FXML
    private void PDF(ActionEvent event) {
        {
        Pdf pd=new Pdf();
        try{
        pd.GeneratePdf("Liste Of Reclamation");
            System.out.println("impression done");
        } catch (Exception ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
            }

    }
}
}

