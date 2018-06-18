package ClientSide.Controllers;

import ClientSide.Client;
import General.Request;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInOrSignUp extends FatherController {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void singIn(ActionEvent actionEvent) {
        try {
            Client.oos.writeObject(Request.SIGN_IN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goTo("sign_in");
    }

    public void singUp(ActionEvent actionEvent) {
    }
}
