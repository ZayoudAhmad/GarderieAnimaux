package lasttest;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Azertyy
 */
public class main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
           Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));
           Scene scene = new Scene(root);
           primaryStage.setTitle("Garderie!");
           primaryStage.setScene(scene);
           primaryStage.setResizable(true);
            primaryStage.show();
        }catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
