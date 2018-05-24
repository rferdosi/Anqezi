package Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends FatherController implements Initializable {

    public VBox myBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Node> children = myBoard.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            HBox hBox = (HBox) node;
            for (int j = 0; j < 8; j++) {
                hBox.getChildren().add(Main.board.getCells(i, j));
                //adding cells to board
            }
        }

    }
}
