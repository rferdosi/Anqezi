package General.Pieces;

import General.Board.Side;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public void getPossibleChoices() {
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
