package ClientSide.Controllers;

import ClientSide.Client;
import General.Request;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomingController extends MotherController {

    public void login(ActionEvent actionEvent) {
        try {
            Client.oos.writeObject(Request.SIGN_IN);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goTo("login");
        System.err.println("yesss");
    }

    public void singUp(ActionEvent actionEvent) {
        try {
            Client.oos.writeObject(Request.SIGN_UP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        goTo("registration");

    }
}
