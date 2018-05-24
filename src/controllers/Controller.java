package controllers;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import Board.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public VBox myBoard;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Node node : myBoard.getChildren()) {
            HBox hBox = (HBox) node;
            for (int i = 0; i < 8; i++) {
                hBox.getChildren().add()
            }
        }

    }
}
