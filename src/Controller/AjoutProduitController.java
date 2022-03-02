/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entities.Produit;
import Service.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AjoutProduitController {

    @FXML // fx:id="txtDescrip"
    private TextField txtDescrip; // Value injected by FXMLLoader

    @FXML // fx:id="txtImage"
    private TextField txtImage; // Value injected by FXMLLoader

    @FXML // fx:id="txtNom"
    private TextField txtNom; // Value injected by FXMLLoader

    @FXML // fx:id="txtPrix"
    private TextField txtPrix; // Value injected by FXMLLoader

    @FXML // fx:id="txtQte"
    private TextField txtQte; // Value injected by FXMLLoader
    @FXML
    private Button btnRetour;

    @FXML
    void ajouterProduit(ActionEvent event) throws SQLException {
        ProduitService ps = new ProduitService();
            Produit p = new Produit(txtNom.getText(),Integer.parseInt(txtQte.getText()),Float.parseFloat(txtPrix.getText()),txtDescrip.getText(),txtImage.getText());
            
            ps.ajouter(p);
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Success");
            alert1.setContentText("Product is added successfully!");
            alert1.show();
            txtNom.setText("");
            txtQte.setText("");
            txtPrix.setText("");
            txtDescrip.setText("");
            txtImage.setText("");
           
    }
    
    
    @FXML
    void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Produit.fxml"));
        Stage window = (Stage) btnRetour.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Gestion Produit");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    }

}
