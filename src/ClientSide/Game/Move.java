package ClientSide.Game;

import ClientSide.Game.Pieces.Piece;

import java.io.Serializable;

public class Move implements Serializable {
    private static final long serialVersionUID = 123456712;
    private Piece movedPiece;
    private Cell srcCell;
    private Cell distCell;

    public Move(Piece movedPiece, Cell srcCell, Cell distCell) {
        this.movedPiece = movedPiece;
        this.srcCell = srcCell;
        this.distCell = distCell;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Cell getSrcCell() {
        return srcCell;
    }

    public void setSrcCell(Cell srcCell) {
        this.srcCell = srcCell;
    }

    public Cell getDistCell() {
        return distCell;
    }

    public void setDistCell(Cell distCell) {
        this.distCell = distCell;
    }
}