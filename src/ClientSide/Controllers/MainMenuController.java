package ClientSide.Controllers;

import ClientSide.Client;
import ClientSide.Game.Game;
import General.Request;
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
    public static boolean firstTime = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText("Welcome " + Client.getUser().getName());
        ArrayList<Game> requestedGamesArrayList = null;
        if (!firstTime) {
            try {
                Client.oos.writeObject(Request.GET_GAME_REQUESTS);
                System.out.println("Hi Solar System!");
                requestedGamesArrayList = (ArrayList<Game>) Client.ois.readObject();
            } catch (IOException e) {
                System.out.println("I Have The Cake!");
            } catch (ClassNotFoundException e) {
                System.out.println("Casting Problem");
            }
            requestedGames.setItems(FXCollections.observableArrayList(requestedGamesArrayList));
            requestedGames.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                GameAcceptController.game = newValue;
                open("gameAccept");
            });
            gamesRefresh();
        } else {
            firstTime = false;
        }
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
            System.out.println(games);
            requestedGames.setItems(FXCollections.observableArrayList(games));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
