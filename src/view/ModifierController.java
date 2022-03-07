/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceHebergement;
import Service.ServiceReservation;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Hebergement;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ModifierController implements Initializable {

    @FXML
    private TextField tftitre;
    @FXML
    private TextField Adrestx;
    @FXML
    private TextField TypeTx;
    @FXML
    private TextField nbrch;
    @FXML
    private TextField typecham;
    @FXML
    private Button modifi;
    @FXML
    private ComboBox<String > list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();
    
    @FXML
    private Label afficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    
        list();
    }
        
        
        // TODO
        

    @FXML
    private void pagemodifbuton(ActionEvent event) {
        
         ServiceHebergement e =new ServiceHebergement();
         int value = Integer.parseInt(list.getValue());
          Hebergement he =new Hebergement(tftitre.getText(), Adrestx.getText(), TypeTx.getText(), Integer.parseInt(nbrch.getText()), typecham.getText());
         
        e.modifer(he);
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText(" Vos champs on ete modifer avec succes ");
        alert.show();
        
        
        
        
        
        
        
        
    }
    
    
    @FXML
    void Affiche(ActionEvent event) {
         ServiceHebergement e =new ServiceHebergement();
                afficher.setText(e.afficher().toString());
         
        
        
        
        
        
        

    }


    @FXML
    private void getvalue(ActionEvent event) {
        
        try {
            int value = Integer.parseInt(list.getValue());
             String querry = "select * from `hebergement` where id  = " + value;
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(querry);
            
            while (rs.next()) {
                tftitre.setText(rs.getString("nom"));
                Adrestx.setText(rs.getString("adresse"));
                TypeTx.setText(rs.getString("type"));
                nbrch.setText(rs.getString("nbr_chambre"));
                typecham.setText(rs.getString("type_chambre"));
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
    
    
    public void list()
    {
        
        ServiceHebergement e =new ServiceHebergement();
                afficher.setText(e.afficher().toString());
    }
         
        
        
} 
        

        
        
        
        
    
    

