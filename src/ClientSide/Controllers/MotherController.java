package ClientSide.Controllers;

import ClientSide.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class MotherController {

    @FXML
    Button CloseButton;

    public void CloseApp() {
        Client.ExitRequested = true;
    }

    public void goTo(String name) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXMLs/" + name + ".fxml"));
        } catch (IOException e) {
            System.out.println("FXML Bug");
        }
        Scene myScene = new Scene(root);
        //myScene.getStylesheets().add("../CSS/" + name + ".css");
        Client.pStage.setScene(myScene);
        Client.pStage.show();
    }
    public void open(String name){
        Stage newGameStage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../FXMLs/"+name+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        newGameStage.setTitle(name);
        newGameStage.setScene(new Scene(root));
        newGameStage.setResizable(false);
        newGameStage.show();
    }
}
