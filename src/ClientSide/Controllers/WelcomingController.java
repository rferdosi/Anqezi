package ClientSide.Controllers;

import ClientSide.Client;
import General.Request;
import General.User.User;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class WelcomingController extends MotherController {


    public TextField username;
    public PasswordField password;
//    public Label message;
//    public CheckBox rememberMeCheckBox;

    public void login(ActionEvent actionEvent) {
        User user = new User(username.getText(), password.getText());
        try {
            Client.oos.writeObject(user);
            boolean accepted = (boolean) Client.ois.readObject();
            if (accepted) {
                Client.user = (User) Client.ois.readObject();
                goTo("mainMenu");
//                if (rememberMeCheckBox.isSelected()) {
//                    Client.serialize();
//                }
//            } else {
//                message.setText("wrong username or password");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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
