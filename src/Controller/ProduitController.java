/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Service.ProduitService;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ProduitController {
    
    @FXML
    private Button btnAffichage;

    @FXML
    private Button btnAjout;

    @FXML
    private Button btnModif;
    
    @FXML
    private Button btnSup;

    @FXML
    private Label listP;

    @FXML
    void RederigerAjout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AjoutProduit.fxml"));
        Stage window = (Stage) btnAjout.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Ajout Produit");
    }
    
      @FXML
    void rederigerMotif(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ModifProduit.fxml"));
        Stage window = (Stage) btnModif.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Modifier Produit");
    }

    @FXML
    void rederigerSup(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/supprimerProduit.fxml"));
        Stage window = (Stage) btnSup.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Suppression Produit");
    }

    @FXML
    void refreshProduit(ActionEvent event) {
        ProduitService ps =  new ProduitService();
        listP.setText(ps.afficher().toString());

    }
    
    void initialize() {
    }
    
}
