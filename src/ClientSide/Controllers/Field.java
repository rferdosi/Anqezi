package ClientSide.Controllers;

import General.User.SimpleUser;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class Field {
    private SimpleUser simpleUser;
//    public ImageView image;
//    public HBox stars;
    public Label name;
    public AnchorPane back;

    public Field(SimpleUser simpleUser) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../FXMLs/field.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.simpleUser = simpleUser;
//        image = simpleUser.getProfilePictureAddress();
        name.setText(simpleUser.getName());

    }

    public AnchorPane getBack() {
        return back;
    }
}