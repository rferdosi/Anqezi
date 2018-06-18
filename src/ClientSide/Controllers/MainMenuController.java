package ClientSide.Controllers;

import ClientSide.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends MotherController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void about() {
        goTo("about");
    }

    public void newGame() {
        goTo("game");
    }
}
