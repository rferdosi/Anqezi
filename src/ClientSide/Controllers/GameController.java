package ClientSide.Controllers;

import General.Board.Board;
import General.Board.Side;
import General.Game;
import General.User.Player;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;
    public Board board;
    public static Game game;
    public static Side playerSide;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerSide = Side.White;
        if (game == null) {
        //    game = new Game();
        }
        board = game.getBoard();
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
