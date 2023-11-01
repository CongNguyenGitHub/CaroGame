/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaroGame;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author NguyenNguyen
 */
public class SceneManager {
    static Stage primaryStage;
    static Scene scene1, scene2;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void switchToScene1() {
        primaryStage.setScene(scene1);
    }

    public static void switchToScene2() {
        primaryStage.setScene(scene2);
    }
}
