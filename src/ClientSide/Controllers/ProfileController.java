package ClientSide.Controllers;

import ClientSide.Client;
import General.Request;
import General.User.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    private static User user = Client.getUser();
    public TextField email;
    public TextField name;
    public PasswordField password;
    public TextField username;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        email.setText(user.getEmail());
        name.setText(user.getName());
        username.setText(user.getUsername());

    }

    public void chooseImage(ActionEvent actionEvent) {
    }

    public void saveChanges(ActionEvent actionEvent) {
        user.setEmail(email.getText());
        user.getSimpleUser().setName(name.getText());
        user.setPassword(password.getText());
        user.getSimpleUser().setUsername(username.getText());
        try {
            Client.oos.writeObject(Request.CHANGE_USER);
            Client.oos.writeObject(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
