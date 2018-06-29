package ClientSide.Game;

import General.User.Audience;
import General.User.Player;
import General.User.SimpleUser;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    private Board board;
    private Player player1;
    private Player player2;
    private SimpleUser winner;
    private SimpleUser loser;
    private boolean isDraw;

    ArrayList<Audience> audiences;
    private ArrayList<Move> moves;
    private boolean isRated;
    private boolean isPlayer2Accepted;
    private int time;

    public Board getBoard() {
        return board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer2() {
        return player2;
    }

    public boolean isPlayer2Accepted() {
        return isPlayer2Accepted;
    }

    public void setPlayer2Accepted(boolean player2Accepted) {
        isPlayer2Accepted = player2Accepted;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

    public Game() {

    }

    public Game(Player player1, Player player2, boolean isRated) {
        this.player1 = player1;
        this.player2 = player2;
        this.isRated = isRated;
    }

    {
        board = new Board(this);
        moves = new ArrayList<>();
    }

    public SimpleUser getWinner() {
        return winner;
    }

    public void setWinner(SimpleUser winner) {
        this.winner = winner;
    }

    public SimpleUser getLoser() {
        return loser;
    }

    public void setLoser(SimpleUser loser) {
        this.loser = loser;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public int getTime() {
        return time;
    }

    public boolean isRated() {
        return isRated;
    }

    @Override
    //Override so we can compare two games just by its players
    public boolean equals(Object object) {
        if (object instanceof Game) {
            Game game = (Game) object;
            if (game.getPlayer1().equals(this.player1) && game.getPlayer2().equals(this.player2)) {
                return true;
            }
        }
        return false;
    }
}
