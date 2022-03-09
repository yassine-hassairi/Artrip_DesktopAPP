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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Yassine
 */
public class ModifProduitController implements Initializable {

    
     @FXML
    private Button btnRetour;

    @FXML
    private ComboBox<String> list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList ();

    @FXML
    private TextField showModif;
    
    @FXML
    private TextField txtDescrip;

    @FXML
    private TextField txtImage;

    @FXML
    private TextField txtNom;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtQte;
  @Override
    public void initialize(URL url, ResourceBundle rb) {
       fillCombo();
         list();
      // TODO
    }    

    @FXML
    void ModifierProduit(ActionEvent event) {
        ProduitService ps = new ProduitService();
        int value = Integer.parseInt((String) list.getValue());
        Produit pg = new Produit (value,txtNom.getText(),Integer.parseInt(txtQte.getText()),Float.parseFloat(txtPrix.getText()),txtDescrip.getText(),txtImage.getText());
        ps.modifier(pg);
        list();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("le produit a ete modifié" );
        alert.show();

    }

    @FXML
    void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Produit.fxml"));
        Stage window = (Stage) btnRetour.getScene().getWindow();
        window.setScene(new Scene(root));
        window.setTitle("Gestion Produit");
    }

    @FXML
    void getValue(ActionEvent event) {
        try {
            Connection cnx = myConnection.getInstance().getCnx();
            List<Produit> produits = new ArrayList<>();
            Produit p = new Produit();
            int value = Integer.parseInt(list.getValue());
            System.out.println(value);
            String req = "select * from produit where idProduit = " +value ;
            Statement ps = cnx.createStatement();
            ResultSet rs = ps.executeQuery(req);
            while(rs.next()){                      
              p.setNom(rs.getString("nomProduit"));
              p.setQuantite(rs.getInt("quantite"));
              p.setPrix(rs.getInt("prix"));
              p.setDescription(rs.getString("description"));
              produits.add(p);        
              txtNom.setText(p.getNom());
              txtQte.setText(String.valueOf(p.getQuantite()));
              txtPrix.setText(String.valueOf(p.getPrix()));
              txtDescrip.setText(p.getDescription());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
     private void fillCombo() {
try {
  Connection cnx = myConnection.getInstance().getCnx();
            String req = " select * from produit ";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery(req);
            while(rs.next()){
                options.add(rs.getString("idProduit"));
                
            }
            list.setItems(options);
        } catch (SQLException ex) {
            
        }
    }

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
  
    private void list() {
        ProduitService ps= new ProduitService();
        showModif.setText(ps.afficher().toString());
    }
    
}
