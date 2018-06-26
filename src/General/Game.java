package General;

import General.Board.Board;
import General.User.Audience;
import General.User.Player;
import General.User.SimpleUser;

import java.util.ArrayList;

public class Game {
    private Board board = new Board();
    private SimpleUser player1;
    private SimpleUser player2;
    ArrayList<Audience> audiences;
    boolean isRated;
    boolean isPlayer2Accepted;
//    Time gameTime;

    public Board getBoard() {
        return board;
    }

    public SimpleUser getPlayer1() {
        return player1;
    }

    public SimpleUser getPlayer2() {
        return player2;
    }

    public boolean isPlayer2Accepted() {
        return isPlayer2Accepted;
    }

    public Game() {
    }

    public Game(SimpleUser player1, SimpleUser player2, boolean isRated) {
        this.player1 = player1;
        this.player2 = player2;
        this.isRated = isRated;
    }


}
