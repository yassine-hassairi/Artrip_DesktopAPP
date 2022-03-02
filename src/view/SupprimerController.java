/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Service.ServiceEvenements;
import Service.ServiceReservationEven;
import java.io.IOException;
import java.net.URL;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Evenements;
import model.ReservationEven;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class SupprimerController implements Initializable {

    @FXML
    private ListView<Evenements> SuiviList;
    @FXML
    private ImageView Deletev;
    @FXML
    private Button Show;
    private ServiceEvenements s = new ServiceEvenements();
    private List<Evenements> Ev = s.afficher();
    private int a;
    @FXML
    private TextField search;
    @FXML
    private ImageView Trier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private Button Retour;

      @FXML
    private void Trier(MouseEvent event) {
     List<Evenements> id = s.sortedById();
        SuiviList.getItems().removeAll(Ev);
        SuiviList.getItems().addAll(id);
    }

    @FXML
    private void search(MouseEvent event) {
          List<Evenements> Lieu = s.findByLieu(search.getText());
        SuiviList.getItems().clear();

        SuiviList.getItems().removeAll(Ev);
     SuiviList.getItems().addAll(Lieu);}
    @FXML
    void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Ativite.fxml"));
        Stage window = (Stage) Retour.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    private void Show(ActionEvent event) {
        SuiviList.getItems().clear();

        SuiviList.getItems().addAll(Ev);

    }

    @FXML
    private void Deletev(MouseEvent event) {

        int SelectedId = SuiviList.getSelectionModel().getSelectedIndex();

        ServiceEvenements s = new ServiceEvenements();
        Evenements se = new Evenements();
        se.setId(SuiviList.getItems().get(SuiviList.getSelectionModel().getSelectedIndex()).getId());
        s.supprimer(se.getId());
        SuiviList.getItems().remove(SuiviList.getSelectionModel().getSelectedIndex());
        SuiviList.getItems().clear();
        SuiviList.getItems().addAll(Ev);
        refresh();

    }

    private void GetCode() {
        SuiviList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                a = SuiviList.getSelectionModel().getSelectedIndex();
            }
        });
    }
        private void refresh() {
      ServiceEvenements s = new ServiceEvenements();
       List<Evenements> Ev = s.afficher();
      SuiviList.getItems().clear();
       SuiviList.getItems().addAll(Ev);
    }

 
    

}
