package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

public class Queen extends Piece {

    public Queen(Side side) {
        super(side);
    }
    //     ®Powered By XxNE0xX 8)
    @Override
    public void getPossibleChoices() {
        Bishop bishop = new Bishop(side);
        Rook rook = new Rook(side);
        bishop.cell = this.cell;
        rook.cell = this.cell;
        bishop.getPossibleChoices();
        rook.getPossibleChoices();
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
