package General.Pieces;

import General.Board.Side;
import javafx.scene.image.ImageView;
import General.Board.Cell;

import java.util.ArrayList;

abstract public class Piece {
    protected ImageView imageView;
    protected Cell cell;
    protected Side side;
    protected int row = this.cell.getRow();
    protected int column = this.cell.getColumn();

    public Piece(Side side) {
        this.side = side;
    }

    public void move(Cell destination) {
        if (!destination.isEmpty()) {
            this.cell.getBoard().getPieces().remove(destination.getPiece());
        }
        this.cell = destination;
    }

    public abstract ArrayList<Cell> getPossibleChoices();



}
