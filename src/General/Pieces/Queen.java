package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(Side side) {
        super(side);
    }

    @Override
    public void move(Cell destination) {

    }

    @Override
    public ArrayList<Cell> getPossibleChoices() {

        return null;
    }
}
