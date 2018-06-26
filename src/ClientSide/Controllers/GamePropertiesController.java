package ClientSide.Controllers;

import ClientSide.Client;
import General.Board.Side;
import General.Game;
import General.Request;
import General.User.SimpleUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GamePropertiesController extends MotherController implements Initializable {
    public ComboBox<Side> comboBox;
    public TextField searchTextField;
    public ListView<SimpleUser> searchedList;
    public CheckBox isRatedCheckBox;
    public String selectedUserString;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Side> arrayList = new ArrayList<>();
        arrayList.add(Side.White);
        arrayList.add(Side.Black);
        arrayList.add(Side.Random);
        ObservableList<Side> sides = FXCollections.observableList(arrayList);
        comboBox.setItems(sides);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            ArrayList<SimpleUser> users;
            try {
                Client.oos.writeObject(Request.GET_USERS_TO_STRING);
                Client.oos.writeUTF(searchTextField.getText());
                Client.oos.flush();
                users = (ArrayList<SimpleUser>) Client.ois.readObject();
                searchedList.setItems(FXCollections.observableArrayList(users));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }


    public void gameRequest() {
        SimpleUser requestedUser = searchedList.getSelectionModel().getSelectedItem();
        try {
            Client.oos.writeObject(Request.NEW_GAME_REQUEST);
            Client.oos.writeObject(requestedUser);
            Client.oos.flush();
            Client.oos.writeBoolean(isRatedCheckBox.isSelected());
            Client.oos.writeObject(Client.user);
            Game requestedGame = (Game) Client.ois.readObject();
            GameController.game = requestedGame;
            goTo("game");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
