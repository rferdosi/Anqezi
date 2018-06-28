package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
//        ArrayList<Cell> choices = new ArrayList<>();
//        for (int i = 1; i <= 2; i++) {
//            for (int j = 1; j <= 2; j++) {
//                if (i + j == 3) {
//                    try {
//                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
//                        if (inProgressCell.isEmpty() ||
//                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
//                            choices.add(inProgressCell);
////                            inProgressCell.setPossible(true);
//                        }
//                    } catch (ArrayIndexOutOfBoundsException ignored) {
//                    }
//                    try {
//                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column + j);
//                        if (inProgressCell.isEmpty() ||
//                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
//                            choices.add(inProgressCell);
////                            inProgressCell.setPossible(true);
//                        }
//                    } catch (ArrayIndexOutOfBoundsException ignored) {
//                    }
//                    try {
//                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column - j);
//                        if (inProgressCell.isEmpty() ||
//                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
//                            choices.add(inProgressCell);
////                            inProgressCell.setPossible(true);
//                        }
//                    } catch (ArrayIndexOutOfBoundsException ignored) {
//                    }
//                    try {
//                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column - j);
//                        if (inProgressCell.isEmpty() ||
//                                (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
//                            choices.add(inProgressCell);
////                            inProgressCell.setPossible(true);
//                        }
//                    } catch (ArrayIndexOutOfBoundsException ignored) {
//                    }
//                }
//
//            }
//        }
//        return choices;
    }

    @Override
    public String toString() {
        return "Knight";
    }
}
