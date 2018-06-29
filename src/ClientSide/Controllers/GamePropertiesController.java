package ClientSide.Controllers;

import ClientSide.Client;
import General.Side;
import ClientSide.Game.Game;
import General.Request;
import General.User.Player;
import General.User.SimpleUser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class GamePropertiesController extends MotherController implements Initializable {
    public ComboBox<Side> comboBox;
    public TextField searchTextField;
    public ListView<SimpleUser> searchedList;
    public CheckBox isRatedCheckBox;
    public Label name;
    public Label username;
    public VBox lastGames;
    private SimpleUser selectedUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ArrayList<Side> arrayList = new ArrayList<>();
        arrayList.add(Side.White);
        arrayList.add(Side.Black);
        arrayList.add(Side.Automatic);
        ObservableList<Side> sides = FXCollections.observableList(arrayList);
        comboBox.setItems(sides);
        comboBox.getSelectionModel().selectLast();
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            searchedList.getItems().clear();
            ArrayList<SimpleUser> users;
            if (!searchTextField.getText().isEmpty()) {
                try {
                    Client.oos.writeObject(Request.GET_USERS_TO_STRING);
                    Client.oos.writeUTF(searchTextField.getText());
                    Client.oos.flush();
                    users = (ArrayList<SimpleUser>) Client.ois.readObject();
//                searchedList.getItems().clear();
                    searchedList.setItems(FXCollections.observableArrayList(users));
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
//        searchedList.setCellFactory(param -> new MyListCell());
        searchedList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<SimpleUser>() {
            @Override
            public void changed(ObservableValue<? extends SimpleUser> observable
                    , SimpleUser oldValue, SimpleUser newValue) {
                name.setText(newValue.getName());
                username.setText(newValue.getUsername());
                selectedUser = newValue;

            }
        });

    }


    public void gameRequest() {
        Side side = comboBox.getSelectionModel().selectedItemProperty().get();
        Player player1 = new Player(Client.getUser().getSimpleUser(), side);
        SimpleUser requestedUser = selectedUser;
        Player player2 = new Player(requestedUser, side.getOtherSide());
        boolean isRated = isRatedCheckBox.isSelected();
        Game game = new Game(player1, player1, isRated);
        game.setPlayer2Accepted(false);
        try {
            Client.oos.writeObject(Request.NEW_GAME_REQUEST);
            Client.oos.writeObject(requestedUser);
            Client.oos.writeObject(game);
            Client.oos.flush();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Game Request");
            success.setHeaderText("Game Request Has Been Send");
            success.initModality(Modality.APPLICATION_MODAL);
            Optional<ButtonType> result = success.showAndWait();
            goTo("game");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
