/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entities.Produit;
import Service.ProduitService;
import Utils.myConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class SupprimerProduitController implements Initializable {
    
    @FXML
    private Label afficherL;

    @FXML
    private Button btnRetour;

    @FXML
    private Button btnSup;

    @FXML
    private ComboBox<String> list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList ();

    @FXML
    int getName(ActionEvent event) {
        int value = Integer.parseInt((String) list.getValue());
         System.out.println(value);
        return value;
    }

    @FXML
    void rederigerMenu(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/View/Produit.fxml"));
        Stage window = (Stage) btnRetour.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Gestion Produit");

    }

    @FXML
    void supprimerProduit(ActionEvent event) {
     int value = Integer.parseInt((String) list.getValue());
     System.out.println(value);
     ProduitService ps = new ProduitService();
      ps.supprimerIdP(value);
     list();
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Success");
     alert.setContentText("le produit a ete supprime");
     alert.show();

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCombo();
        list();
    }    

    private void fillCombo() {
        try {
           
            cnx = myConnection.getInstance().getCnx();
            String req = " select * from Produit WHERE etat = 1";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery(req);
            while(rs.next()){
                options.add(rs.getString("idProduit"));
                
            }
            list.setItems(options);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void list() {
        ProduitService ps= new ProduitService();
        afficherL.setText(ps.afficher().toString());
    }
    
}
