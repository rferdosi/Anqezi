package ClientSide.Controllers;

import ClientSide.Client;
import ClientSide.Game.Game;
import General.Tournament;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends MotherController implements Initializable {
    public Label name;
    public ListView<Game> requestedGames;
    public ListView<Tournament> tournoments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText("Welcome " + Client.getUser().getName());
        requestedGames.setItems(FXCollections.observableArrayList(Client.getUser().getRequestedGames()));
        requestedGames.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            GameAcceptController.game = newValue;
            open("gameAccept");
        });
    }

    public void about() {
        open("about");
    }

    public void newGame() {
        open("gameProperties");
    }
}
