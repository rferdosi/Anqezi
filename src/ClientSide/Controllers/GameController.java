package ClientSide.Controllers;

import ClientSide.Client;
import ClientSide.Game.Board;
import ClientSide.Game.Game;
import General.Side;
import General.User.Player;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;
    public Board board;
    public static Game game;
    public static Side playerSide;
    public static int time;
    public static int otherTime;
    public Label label;
    public Label m;
    public Label s;
    public static boolean isTurn = true;
    public static Player player;
    public static Player otherPlayer;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        if (Client.getUser().getSimpleUser().equals(game.getPlayer1().getSimpleUser())) {
//            otherPlayer = game.getPlayer2();
//            player = game.getPlayer1();
//        } else {
//            otherPlayer = game.getPlayer1();
//            player = game.getPlayer2();
//        }
//        time = player.getTime();
//        otherTime = otherPlayer.getTime();
//        playerSide = player.getSide();
        playerSide = Side.White;
        game = new Game();
        board = game.getBoard();
        if (playerSide == Side.White) {
            isTurn = true;
        } else {
            isTurn = false;
        }
        readFromBoard();
        Thread timer = new Thread(new Timer());
        timer.start();
//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                m.setText(Integer.toString(time / 60));
//                s.setText(Integer.toString(time % 60));
//                System.out.println("Timer");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Task task = new Task() {
//            @Override
//            protected Object call() throws Exception {
//                return null;
//            }
//
//            @Override
//            public void run() {
//                while (true) {
//                    m.setText(Integer.toString(time / 60));
//                    s.setText(Integer.toString(time % 60));
//                    System.out.println("Timer");
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();
//        setLabels.start();
    }

    private void readFromBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                HBox row;
                if (playerSide == Side.White)
                    row = (HBox) myBoard.getChildren().get(i);
                else
                    row = (HBox) myBoard.getChildren().get(7 - i);
                row.getChildren().add(board.getCell(i, j));
            }
        }
    }


    public void theme2() {
        board.setTheme("CopperGolden");
        board.updateTextures();
    }

    public void theme1() {
        board.setTheme("CarbonSilver");
        board.updateTextures();
    }
}

class Timer implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (GameController.isTurn)
                GameController.time--;
            else {
//                GameController.otherTime--;
            }
//            GameController.player.setTime(GameController.time);
//            GameController.otherPlayer.setTime(GameController.time);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


