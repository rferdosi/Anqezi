package ClientSide.Controllers;

import General.Board.Board;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;
    public Board board;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (board == null)
            board = new Board();
        readFromBoard();


    }

    private void readFromBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                HBox row = (HBox) myBoard.getChildren().get(i);
                row.getChildren().add(board.getCell(i, j));
            }
        }
    }

}
