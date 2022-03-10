/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.activitepidev;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Sarra
 */
public class ActivitePidev extends Application {
  
  @Override
   public void start(Stage primaryStage) throws Exception{
     //primaryStage.setTitle("java-buddy.blogspot.com");
        
  
      //Parent root  = FXMLLoader.load(getClass().getResource("/view/Ativite.fxml"));
      Parent root  = FXMLLoader.load(getClass().getResource("/view/AfficheActivit.fxml"));
      
      //Parent root  = FXMLLoader.load(getClass().getResource("/view/Map.html"));
        primaryStage.setTitle("Artip page");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
