package ClientSide.Controllers;

import ClientSide.Client;
import ServerSide.Request;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

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
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("C:\\Users\\DearUser\\IdeaProjects\\Anqezi\\src\\ClientSide\\FXMLs\\sign_in.fxml"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Client.getScene().setRoot(root);
    }

    public void singUp(ActionEvent actionEvent) {
    }
}
