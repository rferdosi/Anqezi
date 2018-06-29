package ClientSide.Game.Pieces;

import ClientSide.Game.Cell;
import General.Side;

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
        super.setLabels();
    }

    @Override
    public String toString() {
        return side + "Queen";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Queen queen = new Queen(side);
        queen.cell = (Cell) cell.clone();
        queen.row = row;
        queen.column = column;
        return queen;

    }
}
