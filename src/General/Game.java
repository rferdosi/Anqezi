package General;

import General.Board.Board;
import General.User.Audience;
import General.User.Player;

import java.util.ArrayList;

public class Game {
    private Board board = new Board();
    private Player player1;
    private Player player2;
    ArrayList<Audience> audiences;
    boolean isRated;
    boolean isPlayer2Accepted;
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

    public boolean isPlayer2Accepted() {
        return isPlayer2Accepted;
    }

    public Game(Player player1, Player player2, boolean isRated) {
        this.player1 = player1;
        this.player2 = player2;
        this.isRated = isRated;
    }

    public Game() {

    }
}
