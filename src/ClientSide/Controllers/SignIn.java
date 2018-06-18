package ClientSide.Controllers;

import ClientSide.Client;
import General.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn extends MotherController {
    @FXML
    public TextField userName;
    @FXML
    public PasswordField password;
    @FXML
    public Label message;

    public void signIn(ActionEvent actionEvent) {
        User user = new User(userName.getText(), password.getText());
        try {
            Client.oos.writeObject(user);
            boolean accepted = (boolean) Client.ois.readObject();
            if (accepted) {
                Client.user= (User) Client.ois.readObject();
                goTo("mainMenu");
            }
            else {
                message.setText("wrong username or password");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
