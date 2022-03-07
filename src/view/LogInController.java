/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.java.swing.plaf.windows.resources.windows;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import javafx.scene.Scene;
public class LogInController {

    public LogInController() {

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;



    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        if(username.getText().equals("admin") && password.getText().equals("admin")) {
            wrongLogIn.setText("Success!");
            Parent root = FXMLLoader.load(getClass().getResource("/view/User.fxml"));
            Stage window = (Stage) button.getScene().getWindow() ;
            window.setScene(new Scene(root));
            window.setTitle("Admin");
           
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }   
    
}
