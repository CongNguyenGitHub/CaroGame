/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaroGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author NguyenNguyen
 */
public class Controller1 {
    @FXML
    public void exitProgram(ActionEvent event){
        System.exit(0);
    }
    @FXML
    public void startGame(ActionEvent event){
        SceneManager.switchToScene2();
    }
}
