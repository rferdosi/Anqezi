package Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Board.Board;

public class Main extends Application {
    public static Board board;
    private static Scene scene;
    private static Stage stage;

    public static void setScene(Scene scene) {
        Main.scene = scene;
    }

    public static Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../FXMLs/main_menu.fxml"));
        Scene scene = new Scene(root);
        Main.scene = scene;
        stage = primaryStage;
        primaryStage.setMinHeight(800);
        primaryStage.setResizable(false);
        primaryStage.setMinWidth(1000);
        primaryStage.setTitle("Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        board = new Board();

        //
        launch(args);


    }
}
