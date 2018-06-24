package General;

import General.Board.Board;
import General.User.Audience;
import General.User.Player;

import java.util.ArrayList;

public class Game {
    Board board = new Board();
    Player player1;
    Player player2;
    ArrayList<Audience> audiences;
    boolean isRated;
//    Time gameTime;

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
