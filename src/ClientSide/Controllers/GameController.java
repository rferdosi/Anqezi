package ClientSide.Controllers;

import General.Board.BoardColour;
import General.Board.Cell;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Node> children = myBoard.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            HBox hBox = (HBox) node;
            for (int j = 0; j < 8; j++) {
                if (i + j % 2 == 0) {
                    hBox.getChildren().add(new Cell(BoardColour.Black));
                } else {
                    hBox.getChildren().add(new Cell(BoardColour.White));
                }
            }
        }

    }
}
