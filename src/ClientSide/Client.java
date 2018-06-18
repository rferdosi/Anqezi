package ClientSide;

import General.User.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Client extends Application {
    public static User user;
    public static boolean ExitRequested = false;
    public static Stage pStage;
    public static int width = 600, height = 860;
    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;
    private static Scene scene;
    private static Stage stage;
    private static Socket socket;

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Client.scene = scene;
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
            /*Parent root = null;
            try {
                root = FXMLLoader.load(Client.class.getResource("FXMLs/welcoming.fxml"));
                scene = new Scene(root);
            } catch (IOException e1) {
                e1.printStackTrace();
            }*/
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
        pStage.show();
    }

    public static void main(String[] args) {
        connectToServer();
        deserialize();
        launch(args);
    }

}
