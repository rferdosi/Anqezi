package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public void getPossibleChoices() {
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i + j == 3) {
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                        if (inProgressCell.isEmpty() ||
                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                            inProgressCell.setPossible(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column + j);
                        if (inProgressCell.isEmpty() ||
                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                            inProgressCell.setPossible(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column - j);
                        if (inProgressCell.isEmpty() ||
                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                            inProgressCell.setPossible(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column - j);
                        if (inProgressCell.isEmpty() ||
                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                            inProgressCell.setPossible(true);
                        }
                    } catch (ArrayIndexOutOfBoundsException e){
                        continue;
                    }
                }

            }
        }
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
