package ClientSide.Controllers;

import ClientSide.Client;
import ClientSide.Game.Game;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameAcceptController implements Initializable {

    public static Game game;
    public Label isRated;
    public Label name;
    public Label color;
    public Label time;
//    public Label isRated;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        isRated.setText;
        name.setText(game.getPlayer1().getSimpleUser().getName());
        time.setText(Integer.toString(game.getTime()));
        color.setText(game.getPlayer2().getSide().toString());
        isRated.setText(Boolean.toString(game.isRated()));
    }

    public void accept() {
        game.setPlayer2Accepted(true);
        try {
            Client.oos.writeObject(game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
