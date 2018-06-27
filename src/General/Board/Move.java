package General.Board;

import General.Pieces.Piece;

public class Move {
    private Piece movedPiece;
    private Cell srcCell;
    private Cell distCell;

    public Move(Piece movedPiece, Cell srcCell, Cell distCell) {
        this.movedPiece = movedPiece;
        this.srcCell = srcCell;
        this.distCell = distCell;
    }
}