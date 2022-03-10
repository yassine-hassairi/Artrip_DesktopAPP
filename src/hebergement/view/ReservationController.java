/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hebergement.view;

import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import hebergement.model.Reservation;
import hebergement.service.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class ReservationController implements Initializable {

    @FXML
    private Label affich;

    @FXML
    private Button afficherl;

    @FXML
    private Label desc;


    /* @FXML
     private Label list1;*/
    Connection cnx;
    ObservableList options = FXCollections.observableArrayList();

    @FXML
    private TextField tfliste;

    @FXML
    private Button modifi1;

    private TextField tfnom;

    private TextField tfprenom;

    private TextField tfprix;

    @FXML
    private DatePicker txfdat;
    @FXML
    private TextField tfli;
    @FXML
    private TextField tfdesc;
    @FXML
    private TextField tftyp;
    @FXML
    private Label list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //fillCombo();
        //list();
    }

    /*public void list() {
        ServiceReservation e = new ServiceReservation();
        affich.setText(e.afficher().toString());
    }
     */
    @FXML
    public void addReserv(ActionEvent event) {
        ServiceReservation r = new ServiceReservation();

        //Date date = java.sql.Date.valueOf(this.txfdat.getValue());
        Reservation re = new Reservation(java.sql.Date.valueOf(this.txfdat.getValue()), tfnom.getText(), tfprenom.getText(), tfliste.getText(), tfprix.getText());
        if (("".equals(tfnom.getText())) || ("".equals(tfprenom.getText())) || ("".equals(tfliste.getText())) || ("".equals(tfprix.getText()))) {
            Alert alert1 = new Alert(Alert.AlertType.WARNING);
            alert1.setTitle("Warning");
            alert1.setContentText("Please add informations");
            alert1.setHeaderText("Date Error");
            alert1.setContentText("Please type date in the correct date format!");
            alert1.show();
        } else {
            r.ajouter(re);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Reservation is added successfully!");

            alert.showAndWait();
            alert.show();

            tfnom.setText("");
            tfprenom.setText("");
            tfliste.setText("");
            tfprix.setText("");

        }
    }

    @FXML
    void afffichee(ActionEvent event) {

        ServiceReservation r = new ServiceReservation();
        affich.setText(r.afficher().toString());
    }

    @FXML
    void affficheeee(MouseEvent event) {

    }

    @FXML
    void pagemodif(ActionEvent event) {

    }
}
