/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CaroGame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
/**
 *
 * @author NguyenNguyen
 */
public class Controller2 extends Main implements Initializable {
    @FXML
    private GridPane grid;
    final private char[][] board=new char[15][15];
    private boolean xTurn = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0; i<15; i++) {
            for(int j=0; j<15; j++) {
                Label label = new Label();
                label.setPrefSize(100, 100);
                label.setAlignment(Pos.CENTER); // Căn giữa nội dung của label
                grid.add(label, i, j);                
                label.setOnMouseClicked(event -> handleMouseClicked(event));
            }
        }
    }
    
    public void handleMouseClicked(MouseEvent event) {
        Label node=(Label)event.getSource();
        int row = GridPane.getRowIndex(node); // Lấy số hàng của phần tử node
        int col = GridPane.getColumnIndex(node); // Lấy số cột của phần tử node
        if (board[row][col] == 0) {
            char symbol = xTurn ? 'X' : 'O';
            node.setText(String.valueOf(symbol));
            if (symbol=='X'){
                node.setTextFill(Color.BLUE);            
            }
            else {
                node.setTextFill(Color.RED);
            }
            board[row][col] = symbol;
            node.setDisable(true);
            if (checkWin(row, col, symbol)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText("Chúc mừng, bạn đã chiến thắng!");
                alert.setContentText(String.format("Người chơi %s đã thắng. Chơi lại để tiếp tục!",symbol));
                
                ButtonType reset=new ButtonType("Chơi lại");
                ButtonType quit= new ButtonType("Thoát");
                alert.getButtonTypes().setAll(reset,quit);
                Optional<ButtonType> result=alert.showAndWait();
                if (result.isPresent() &&result.get()==reset){
                    resetGame();
                }
                else if(result.isPresent() &&result.get()==quit){                 
                    this.resetGame();
                    SceneManager.switchToScene1();
                }
            } else {
                xTurn = !xTurn;
            }
        }
    }
    private void resetGame() {
    // Đặt lại trạng thái của board
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = 0;
            }
        }

        // Xóa nội dung của các ô trên GridPane
        for (Node node : grid.getChildren()) {
            if (node instanceof Label ) {
                Label label = (Label) node;
                label.setText("");
                label.setTextFill(Color.BLACK); // Đặt màu chữ mặc định
                label.setDisable(false); // Bật lại ô để chơi
            }
        }

    // Đặt lại lượt chơi cho X
    xTurn = true;
    }
    private boolean checkWin(int row, int col, char symbol) {
        return checkHorizontal(row, col, symbol) || checkVertical(row, col, symbol) || checkDiagonal(row, col, symbol);
    }

    private boolean checkHorizontal(int row, int col, char symbol) {
        int count = 0;
        for (int i = col - 4; i <= col + 4; i++) {
            if (i < 0 || i >= 15) continue;
            if (board[row][i] == symbol) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkVertical(int row, int col, char symbol) {
        int count = 0;
        for (int i = row - 4; i <= row + 4; i++) {
            if (i < 0 || i >= 15) continue;
            if (board[i][col] == symbol) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonal(int row, int col, char symbol) {
        int count = 0;
        for (int i = -4; i <= 4; i++) {
            int newRow = row + i;
            int newCol = col + i;
            if (newRow < 0 || newRow >= 15 || newCol < 0 || newCol >= 15) continue;
            if (board[newRow][newCol] == symbol) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        
        count = 0;
        for (int i = -4; i <= 4; i++) {
            int newRow = row + i;
            int newCol = col - i;
            if (newRow < 0 || newRow >= 15 || newCol < 0 || newCol >= 15) continue;
            if (board[newRow][newCol] == symbol) {
                count++;
                if (count == 5) return true;
            } else {
                count = 0;
            }
        }
        
        return false;
    }
}
