/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceEvenements;
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
import model.Evenements;
import utils.Connexion;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class ModifierController implements Initializable {

    @FXML
    private Label affiche;

    @FXML

    private ComboBox<String> list;
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();

    @FXML
    private TextField tfli;

    @FXML
    private TextField tfdesc;

    @FXML
    private TextField txtIm;

    @FXML
    private TextField txtprix;

    @FXML
    private TextField txtty;

    @FXML
    private Button Retour;

    @FXML
    private TextField tfTitle;
    @FXML
    private DatePicker txfdat;

    @FXML
    void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Ativite.fxml"));
        Stage window = (Stage) Retour.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    /**
     *
     * @param event
     */
    @FXML
    public void getvalue(ActionEvent event) {

        try {
            int value = Integer.parseInt(list.getValue());
            LocalDate dt = txfdat.getValue();
            System.out.println(value);
            String querry = "select * from `evenement` where id  = " + value;
            Statement stm = cnx.createStatement();

            ResultSet rs = stm.executeQuery(querry);

            while (rs.next()) {
                tfTitle.setText(rs.getString("Titre"));
                tfli.setText(rs.getString("Lieu"));
                tfdesc.setText(rs.getString("Description"));
                txtIm.setText(rs.getString("Image"));
                txtty.setText(rs.getString("Type"));
                txfdat.setValue(dt);
                txtprix.setText(rs.getString("prix"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ModifierController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void modifierlv(ActionEvent event) {

        ServiceEvenements e = new ServiceEvenements();
        int value = Integer.parseInt(list.getValue());
        Evenements ev = new Evenements(value, tfTitle.getText(), tfli.getText(), tfdesc.getText(), txtIm.getText(), txtty.getText(), java.sql.Date.valueOf(this.txfdat.getValue()), txtprix.getText());

        e.modifer(ev);
        list();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("l'activité a ete modifié");
        alert.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillCombo();
        list();
        // TODO
    }

    public void list() {
        ServiceEvenements e = new ServiceEvenements();
        affiche.setText(e.afficher().toString());
    }

    public void fillCombo() {
        try {
            cnx = Connexion.getInstance().getCnx();
            String querry = "SELECT * FROM `evenement`";
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

    @FXML
    private void Affiche(ActionEvent event) {

        ServiceEvenements e = new ServiceEvenements();
        affiche.setText(e.afficher().toString());

    }
}
