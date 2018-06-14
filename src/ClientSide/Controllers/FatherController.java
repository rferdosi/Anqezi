package ClientSide.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class FatherController implements Initializable {
    public void goTo(String url) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("./FXMLs/" + url + ".fxml"));
            Main.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wtf");
        }
    }
}
