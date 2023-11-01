/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaroGame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author NguyenNguyen
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            SceneManager.setPrimaryStage(primaryStage);
            
            Scene scene1 = new Scene(FXMLLoader.load(getClass().getResource("scene1.fxml")));
            Scene scene2 =new Scene(FXMLLoader.load(getClass().getResource("scene2.fxml")));
            
            SceneManager.scene1 = scene1;
            SceneManager.scene2 = scene2;
            
            primaryStage.setScene(scene1);
            Image icon = new Image(getClass().getResource(".//image//icon.png").toExternalForm());
            primaryStage.getIcons().add(icon);
            primaryStage.show();
          
        } 
        catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
