package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public void getPossibleChoices() {
        for (int i = -2; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
//                TODO Kian change your method
//                Done Dude :)
                try {
                    Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                    if (inProgressCell.isEmpty() ||
                            (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                        inProgressCell.setPossible(true);
                        System.out.println("I SEE forward " + inProgressCell.toString());
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("AM I DEAD?! " + (row + i) + " " + (column + j));
                    continue;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
