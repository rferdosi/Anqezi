package ClientSide.Controllers;

import General.Board.Board;
import General.Board.Side;
import General.Game;
import General.User.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;
    public Board board;
    public static Game game;
    public static Side playerSide;
    public VBox time;
    public  Label label;

    public static void setLabelText() {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        if (!game.isPlayer2Accepted())
//            label.setText("Waiting for " + game.getPlayer2().getSimpleUser().getName());
        playerSide = Side.White;
        if (game == null) {
            game = new Game();
        }
        board = game.getBoard();
//        Board.needToMove = true;
        if (playerSide == Side.White)
            Board.isTurn = true;
        readFromBoard();
        //Todo set maxTime here!
        timeManagement(500000);
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

    private void timeManagement(long maxTime) {
        long endTime = maxTime;
        Label timeLabel = new Label();
        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        final Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(500),
                        event -> {
                            final long diff = endTime - System.currentTimeMillis();
                            if (diff < 0) {
                                //  timeLabel.setText( "00:00:00" );
                                timeLabel.setText(timeFormat.format(0));
                            } else {
                                timeLabel.setText(timeFormat.format(diff));
                            }
                        }
                )
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

//        time.getChildren().add(timeline);
    }

}


