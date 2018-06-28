package General;

import ClientSide.Controllers.GameController;
import General.Board.Board;
import General.Board.Move;
import General.User.Audience;
import General.User.Player;
import General.User.SimpleUser;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private Board board = new Board(this);
    private Player player1;
    private Player player2;
    ArrayList<Audience> audiences;
    private ArrayList<Move> moves;
    private boolean isRated;
    private boolean isPlayer2Accepted;
    private GameController gameController;
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

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public Game() {

    }

    public Game(Player player1, Player player2, boolean isRated) {
        this.player1 = player1;
        this.player2 = player2;
        this.isRated = isRated;
    }
    {
        moves = new ArrayList<>();
    }



}
