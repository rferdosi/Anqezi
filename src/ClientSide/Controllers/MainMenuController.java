package ClientSide.Controllers;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController extends MotherController implements Initializable {
//    public Label welcomeLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        welcomeLabel.setText("Hello " + Client.user.getName());
    }

    public void about() {
        goTo("about");
    }

    public void newGame() {
        goTo("gameProperties");
    }
}
