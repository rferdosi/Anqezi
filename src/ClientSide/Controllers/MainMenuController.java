package ClientSide.Controllers;

import ClientSide.Client;
import General.Game;
import General.Tournament;
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
    public ListView<Tournament>tournoments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        name.setText("Welcome " + Client.getUser().getName());
        requestedGames.setItems(FXCollections.observableArrayList(Client.getUser().getRequestedGames()));
    }

    public void about() throws IOException {
        Stage newGameStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/about.fxml"));
        newGameStage.setTitle("about");
        newGameStage.setScene(new Scene(root));
        newGameStage.setResizable(false);
        newGameStage.show();
    }

    public void newGame() throws IOException {
        Stage newGameStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/gameProperties.fxml"));
        newGameStage.setTitle("new Game");
        newGameStage.setScene(new Scene(root));
        newGameStage.setResizable(false);
        newGameStage.show();
    }
}
