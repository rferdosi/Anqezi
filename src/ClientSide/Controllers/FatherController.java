package ClientSide.Controllers;

import ClientSide.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.io.IOException;

public abstract class FatherController implements Initializable {
    public void goTo(String url) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/" + url + ".fxml"));
            Client.getScene().setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("wtf");
        }
    }
}
//C:\Users\DearUser\IdeaProjects\Anqezi\src\ClientSide\Controllers\FatherController.java
//        C:\Users\DearUser\IdeaProjects\Anqezi\src\ClientSide\Client.java
//        C:\Users\DearUser\IdeaProjects\Anqezi\src\ClientSide\FXMLs