package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Side side) {
        super(side);
    }

    //     ®Powered By XxNE0xX 8)
    @Override
    public void setLabels() {
        Bishop bishop = new Bishop(side);
        Rook rook = new Rook(side);
        bishop.cell = this.cell;
        rook.cell = this.cell;
        bishop.setLabels();
        rook.setLabels();
    }

    @Override
    public String toString() {
        return "Queen";
    }
}
