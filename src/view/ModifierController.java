/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entites.Reclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ServiceReclamation;
import utils.Connexion;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class ModifierController implements Initializable {
    
   
    @FXML
    private Button Retour;

    @FXML
    private Label affiche;

    @FXML
    private ComboBox<String> list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();


    @FXML
    private TextField tfdesc;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tfobjet;

    @FXML
    private TextField tfprenom;

    @FXML
    private TextField tftel;

    @FXML
    private DatePicker txfdat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCombo();
        list();
        // TODO
    }    
    
     @FXML
    void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Reclamationfxml.fxml"));
        Stage window = (Stage) Retour.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    
     @FXML
    public void getvalue(ActionEvent event) {

       
         try {
            int value = Integer.parseInt(list.getValue());
            LocalDate dt = txfdat.getValue();
            System.out.println(value);
            String querry = "select * from `reclamation` where id  = " + value;
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                tfnom.setText(rs.getString("nom"));
                tfprenom.setText(rs.getString("prenom"));
                tfdesc.setText(rs.getString("description"));
                tfobjet.setText(rs.getString("objet"));
                tftel.setText(rs.getString("numero_mobile"));
                txfdat.setValue(dt);


            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void modifierlv(ActionEvent event) {
        
         ServiceReclamation e = new ServiceReclamation();
        int value = Integer.parseInt(list.getValue());
        Reclamation ev = new Reclamation(value, tfnom.getText(),tfprenom.getText(),tfdesc.getText(),tfobjet.getText(),Integer.parseInt(tftel.getText()),java.sql.Date.valueOf(this.txfdat.getValue()));

        e.modifier(ev);
        list();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Votre reclamation a ete modifiée avec succés");
        alert.show();
  
    }
    
    

    @FXML
    private void Affiche(ActionEvent event) {
        
        ServiceReclamation e = new ServiceReclamation();
        affiche.setText(e.affcher().toString());
    }
    
    
    
        public void fillCombo() {
        try {
            cnx = Connexion.getInstance().getCnx();
            String querry = "SELECT * FROM `reclamation`";
            PreparedStatement ps = cnx.prepareStatement(querry);
            ResultSet rs = ps.executeQuery(querry);
            while (rs.next()) {
                options.add(rs.getString("id"));

            }
            list.setItems(options);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void list() {
                ServiceReclamation e = new ServiceReclamation();
        affiche.setText(e.affcher().toString());
    }

}
