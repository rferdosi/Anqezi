package ClientSide.Controllers;

import ClientSide.Client;
import General.User.User;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUp {
    public TextField name;
    public TextField username;
    public PasswordField password;
    public TextField age;
    public TextField email;
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private boolean nameValidate(String name) {
        return name.length() > 0;
    }

    private boolean usernameValidate(String username) throws IOException, ClassNotFoundException {
        Client.oos.writeObject(username);
        return (boolean) Client.ois.readObject();
    }

    private boolean passwordValidate(String password) {
        return password.length() > 6;
    }

    private boolean emailValidate(String email) throws IOException, ClassNotFoundException {
        Client.oos.writeObject(email);
        if ((boolean) Client.ois.readObject()) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
            return matcher.find();
        } else {
            return false;
        }
    }

    public void signUp(ActionEvent actionEvent) {
        String nameStr = name.getText();
        String usernameStr = username.getText();
        String emailStr = email.getText();
        String passwordStr = password.getText();
        int ageInt = Integer.parseInt(age.getText());
        try {
            if (nameValidate(nameStr) && usernameValidate(usernameStr)
                    && passwordValidate(passwordStr) && emailValidate(emailStr)) {
                User user = new User(nameStr, usernameStr, emailStr, passwordStr, ageInt);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
