/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.view;

import event.Service.ServiceEvenements;
import event.Service.ServiceReservationEven;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import event.model.Evenements;
import event.model.ReservationEven;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Sarra
 */
public class ReservationController implements Initializable {
   

    @FXML
    private TextField tfli;

    @FXML
    private TextField tfdesc;

    @FXML
    private TextField txtIm;

    @FXML
    private DatePicker txfdat;

    @FXML
    private TextField tfTitle;

    @FXML
    private Button modifi1;

    @FXML
    private Button suivi;

    @FXML
    private Label list;


    private Label aff;
    
    @FXML
    private TextField tftyp;
    @FXML
    private TextField ltflieu;
    

 ServiceReservationEven s = new  ServiceReservationEven();
     List<ReservationEven> reservationEven = s.afficher2();
    
  
   ServiceEvenements e =new ServiceEvenements ();
   List<Evenements> evenement =e.afficher();
    @FXML
    private Label desc;
    private Label affich;
    @FXML
    private Button afficherl;
    @FXML
    private ListView<ReservationEven> SuiviList;
    @FXML
    private Button map;
    /**
     * Initializes the controller class.
     */
       // List<Evenements> evenements  ev = new  evenements();
       // List<Evenements> evenements =ev.afficher();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    } 
    @FXML
      
    void addReserv(ActionEvent event) {
          ServiceReservationEven r =new ServiceReservationEven ();
          
           Date date= java.sql.Date.valueOf(this.txfdat.getValue());
          ReservationEven re =new ReservationEven (Integer.parseInt(tfTitle.getText()),tfdesc.getText(),tftyp.getText(),ltflieu.getText(),Integer.parseInt(tfli.getText()),txtIm.getText(),java.sql.Date.valueOf(this.txfdat.getValue()));
       if(("".equals(tfTitle.getText()))||("".equals(tfdesc.getText()))||("".equals(tftyp.getText()))||("".equals(ltflieu.getText()))||("".equals(tfli.getText()))||("".equals(txtIm.getText())))
        {
      Alert alert1 = new Alert(Alert.AlertType.WARNING);
        alert1.setTitle("Warning");
        alert1.setContentText("Please add informations");
        alert1.show();}
        else{
         r.ajouter(re);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setContentText("Activité is added successfully!");
        
       alert.showAndWait();
        alert.show();
        tfTitle.setText("");
        tfdesc.setText("");
        tftyp.setText("");
      ltflieu.setText("");
        tfli.setText("");
  
        txtIm.setText("");
         
        Notifications notificationBuilder = Notifications.create()
        .title("Notify").text("Resrvation successfully ").graphic(null)
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }
       
        
        };
    

    
    
    @FXML
    void pagemodif(ActionEvent event) throws IOException {
Parent root = FXMLLoader .load(getClass().getResource("/event/view/AfficheActivit.fxml"));
    Stage window = (Stage) modifi1.getScene().getWindow();
    window.setScene(new Scene(root));
    
    }

  

 

    @FXML
    
     void pagesuivi (ActionEvent event) throws IOException {
Parent root = FXMLLoader .load(getClass().getResource("/event/view/Suivi.fxml"));
    Stage window = (Stage) suivi.getScene().getWindow();
    window.setScene(new Scene(root));
    


  

     }

    @FXML
    private void affficheeee(MouseEvent event) {
    }

    private void afffichee(ActionEvent event) {
        
    }

    @FXML
    private void Show(ActionEvent event) {
         SuiviList.getItems().clear();

         SuiviList.getItems().addAll(reservationEven);
    } 
        
    }


