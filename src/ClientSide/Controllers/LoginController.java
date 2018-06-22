package ClientSide.Controllers;

import ClientSide.Client;
import General.User.User;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController extends MotherController {

    public TextField userName;
    public PasswordField password;
    public Label message;
    public CheckBox rememberMeCheckBox;

    public void signIn() {
        User user = new User(userName.getText(), password.getText());
        try {
            Client.oos.writeObject(user);
            boolean accepted = (boolean) Client.ois.readObject();
            if (accepted) {
                Client.user = (User) Client.ois.readObject();
                goTo("mainMenu");
                if (rememberMeCheckBox.isSelected()) {
                    Client.serialize();
                }
            } else {
                message.setText("wrong username or password");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
