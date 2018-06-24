package General.Pieces;

import General.Board.Side;
import javafx.scene.image.ImageView;
import General.Board.Cell;

import java.util.ArrayList;

abstract public class Piece {
    protected ImageView imageView;
    protected Cell cell;
    protected Side side;
    protected int row;
    public static Piece lastSelectedPiece;

    public void setRowAndColumn() {
        row = this.cell.getRow();
        column = this.cell.getColumn();
    }

    protected int column;

    public Piece(Side side) {
        this.side = side;
    }

    public void move(Cell destination) {
        if (!destination.isEmpty() && destination.getPiece().side != this.side) {
            this.cell.getBoard().getPieces().remove(destination.getPiece());
        }
        this.cell.setPiece(null);
        this.cell = destination;
        destination.setPiece(this);
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Side getSide() {
        return side;
    }

    public abstract void getPossibleChoices();

    @Override
    public String toString() {
        return side.toString() + " ";
    }
}
