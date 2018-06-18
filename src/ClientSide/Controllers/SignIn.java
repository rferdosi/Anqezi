package ClientSide.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class SignIn extends FatherController {
    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;
    @FXML
    public Label message;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void signIn(ActionEvent actionEvent) {

    }
}
