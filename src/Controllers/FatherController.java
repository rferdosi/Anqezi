package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FatherController {
    public void goTo(String fxml) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/" + fxml + ".fxml"));
            Main.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wtf");
        }
    }
}
