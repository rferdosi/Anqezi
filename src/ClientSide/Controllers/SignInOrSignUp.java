package ClientSide.Controllers;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInOrSignUp extends FatherController {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void singIn(ActionEvent actionEvent) {
        goTo("about");
    }

    public void singUp(ActionEvent actionEvent) {
    }
}
