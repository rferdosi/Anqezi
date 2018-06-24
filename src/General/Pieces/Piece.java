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
    protected int column;

    public Piece(Side side) {
        this.side = side;
    }

    public void setRowAndColumn() {
        row = this.cell.getRow();
        column = this.cell.getColumn();
    }

    public void move(Cell destination) {
        if (!destination.isEmpty()) {
            this.cell.getBoard().getPieces().remove(destination.getPiece());
        }
        this.cell = destination;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public abstract ArrayList<Cell> getPossibleChoices();



}
