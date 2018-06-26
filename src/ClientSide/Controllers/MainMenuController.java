package ClientSide.Controllers;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void newGame() throws IOException {
        Stage newGameStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/gameProperties.fxml"));
        newGameStage.setTitle("new Game");
        newGameStage.setScene(new Scene(root));
        newGameStage.setResizable(false);
        newGameStage.show();
    }
}
