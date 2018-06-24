package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public ArrayList<Cell> getPossibleChoices() {
        return null;
    }
}
