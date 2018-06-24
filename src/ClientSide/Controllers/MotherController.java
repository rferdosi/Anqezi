package ClientSide.Controllers;

import ClientSide.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public abstract class MotherController {

    @FXML
    Button CloseButton;
    public void CloseApp(){
        Client.ExitRequested = true;
    }
    public void goTo(String name){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXMLs/" + name + ".fxml"));
        } catch (IOException e) {
            System.out.println("FXML Bug");
        }
        Scene myScene = new Scene(root, Client.width, Client.height);
        //myScene.getStylesheets().add("../CSS/" + name + ".css");
        Client.pStage.setScene(myScene);
        Client.pStage.show();
    }
}
