/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.view;

import gestionutilisateur1.utils.MyConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.time.LocalDate;
//import java.time.chrono.ChronoLocalDate;
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
public class ModifierController implements Initializable {

    
      @FXML
    private Button Retour;

    @FXML
    private Label affiche;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ComboBox<String> list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();

    @FXML
    private TextField tfadresse;

    @FXML
    private TextField tfnbrch;

    @FXML
    private TextField tfnom;

    @FXML
    private TextField tftype;

    @FXML
    private TextField tftypechbr;

    
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
    private void modifier(ActionEvent event) {
     ServiceHebergement e = new ServiceHebergement();
        int value = Integer.parseInt(list.getValue());
        Hebergement ev = new Hebergement(value, tfnom.getText(),  tfadresse.getText(), tftype.getText(), Integer.parseInt(tftype.getText()), tftypechbr.getText());

        e.modifer(ev);
        list();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("l'hebergement a ete modifié");
        alert.show();
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
           Retour.getScene().getWindow().hide();
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
    private void getvalue(ActionEvent event) {
    
        try {
            int value = Integer.parseInt(list.getValue());
            System.out.println(value);
            String querry = "SELECT * FROM `hebergement` where id  = " + value;
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                tfnom.setText(rs.getString("nom"));
                tfadresse.setText(rs.getString("adresse"));
                tftype.setText(rs.getString("type"));
                tfnbrch.setText(rs.getString("nbr_chambre"));
                tftypechbr.setText(rs.getString("type_chambre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void Afficher(ActionEvent event) {
     ServiceHebergement e = new ServiceHebergement();

        affiche.setText(e.afficher().toString());
 
    
    }
    
         public void list() {
                   ServiceHebergement e = new ServiceHebergement();
        affiche.setText(e.afficher().toString());
    }
           public void fillCombo() {
        try {
            cnx = MyConnexion.getInstance().getCnx();
            String querry = "SELECT * FROM `hebergement`";
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

    }

