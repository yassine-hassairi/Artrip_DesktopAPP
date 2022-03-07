/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entites.Reclamation;
import java.awt.event.MouseEvent;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import service.ServiceReclamation;

/**
 * FXML Controller class
 *
 * @author IMEN
 */
public class SupprimerController implements Initializable {
    
      @FXML
    private ImageView Deletev;

    @FXML
    private Button Retour;

    @FXML
    private Button Show;

    @FXML
    private ListView<Reclamation> SuiviList;
    private ServiceReclamation s = new ServiceReclamation();
    private List Ev = s.affcher();
    private int a;

    @FXML
    private ImageView Trier;

    @FXML
    private TextField search;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
 

    @FXML
    void Show(ActionEvent event) {
        
                SuiviList.getItems().clear();
                SuiviList.getItems().addAll(Ev);

    }


    @FXML
    void goback(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/Reclamationfxml.fxml"));
        Stage window = (Stage) Retour.getScene().getWindow();
        window.setScene(new Scene(root));

    }

  
      @FXML
       private void GetCode() {
        SuiviList.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent arg0) {
                a = SuiviList.getSelectionModel().getSelectedIndex();
            }
        });
    }
       
           private void refresh() {
      ServiceReclamation s = new ServiceReclamation();
       List<Reclamation> Ev = s.affcher();
      SuiviList.getItems().clear();
       SuiviList.getItems().addAll(Ev);
    }


    @FXML
    private void Trier(javafx.scene.input.MouseEvent event) {
        List<Reclamation> id = s.sortedById();
        SuiviList.getItems().removeAll(Ev);
        SuiviList.getItems().addAll(id);
    }

    @FXML
    private void search(ActionEvent event) {
        List<Reclamation> Id = s.findById(Integer.parseInt(search.getText()));
        SuiviList.getItems().clear();
        SuiviList.getItems().removeAll(Ev);
     SuiviList.getItems().addAll(Id);

    }

    @FXML
    private void Deletev(javafx.scene.input.MouseEvent event) {
        int SelectedId = SuiviList.getSelectionModel().getSelectedIndex();

        ServiceReclamation s = new ServiceReclamation();
        Reclamation se = new Reclamation();
        se.setId(SuiviList.getItems().get(SuiviList.getSelectionModel().getSelectedIndex()).getId());
        s.supprimer(se.getId());
        SuiviList.getItems().remove(SuiviList.getSelectionModel().getSelectedIndex());
        SuiviList.getItems().clear();
        SuiviList.getItems().addAll(Ev);
        refresh();
    }

    
}
