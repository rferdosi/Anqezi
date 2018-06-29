package ClientSide.Controllers;

import ClientSide.Client;
import General.User.User;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private static User user = Client.getUser();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
