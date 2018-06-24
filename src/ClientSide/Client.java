package ClientSide;

import General.Request;
import General.User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class Client extends Application {
    public static User user;
    public static boolean ExitRequested = false;
    public static Stage pStage;
    public static int width = 600, height = 860;
    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;
    private static Scene scene;
    private static Socket socket;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Client.scene = scene;
    }

    public static void serialize() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("user.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Close_Alert(javafx.stage.WindowEvent e) {
        Alert close = new Alert(Alert.AlertType.CONFIRMATION);
        close.setTitle("Exit?!");
        close.setHeaderText("Are You Sure You Want to Exit?");
        close.initModality(Modality.APPLICATION_MODAL);
        Optional<ButtonType> result = close.showAndWait();
        if (result.get() == ButtonType.OK) {
            try {
                oos.writeObject(Request.EXIT);
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                System.exit(0);
            }
        } else {
            e.consume();
        }
    }

    private static void deserialize() {
        try {
            FileInputStream fileInputStream = new FileInputStream("user.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
            oos.writeObject(Request.SEND_USER);
            oos.writeObject(user);
        } catch (IOException | ClassNotFoundException ignored) {

        }
    }

    private static void connectToServer() {
        try {
            socket = new Socket("localhost", 8569);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/welcoming.fxml"));
        pStage.setTitle("Chess");
        pStage.setScene(scene);
        pStage.setScene(new Scene(root, width, height));
        primaryStage.setOnCloseRequest(Client::Close_Alert);
        pStage.show();
    }

    public static void main(String[] args) {
        connectToServer();
        deserialize();
        launch(args);
    }

}
