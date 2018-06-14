package ClientSide;

import ClientSide.User.User;
import ServerSide.ClientHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    private static User user;
    private ClientHandler clientHandler;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private static Scene scene;
    private static Stage stage;
    private static Socket socket;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Client.scene = scene;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Client.stage = stage;
    }

    private static void serialize() {
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

    private static void deserialize() {
        try {
            FileInputStream fileInputStream = new FileInputStream("user.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            user = (User) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Parent root = null;
            try {
                root = FXMLLoader.load(Client.class.getResource("./FXMLs/signIn_signUp.fxml"));
                scene = new Scene(root);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private static void connectToServer() {
        try {
            socket = new Socket("localhost", 1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        connectToServer();
        deserialize();
        launch(args);
    }

}
