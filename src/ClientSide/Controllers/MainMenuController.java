package ClientSide.Controllers;

import ClientSide.Client;
import ClientSide.Game.Game;
import General.Request;
import General.Tournament;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
//        gamesRefresh();
    }

    public void about() {
        open("about");
    }

    public void newGame() {
        open("gameProperties");
    }

    public void gamesRefresh() {
        try {
            Client.oos.writeObject(Request.GET_GAME_REQUESTS);
            ArrayList<Game> games = (ArrayList<Game>) Client.ois.readObject();
            requestedGames.setItems(FXCollections.observableArrayList(games));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
