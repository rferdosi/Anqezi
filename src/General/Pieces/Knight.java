package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                if (i + j == 3) {
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                        labelGiver(inProgressCell);
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column + j);
                        labelGiver(inProgressCell);
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row + i, column - j);
                        labelGiver(inProgressCell);
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                    try {
                        Cell inProgressCell = this.cell.getBoard().getCell(row - i, column - j);
                        labelGiver(inProgressCell);
                    } catch (ArrayIndexOutOfBoundsException ignored) {
                    }
                }

            }
        }
        super.setLabels();
    }

    private void labelGiver(Cell inProgressCell) {
        if (inProgressCell.isEmpty()) {
            inProgressCell.setLabel(Label.POSSIBLE);
        } else if (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side) {
            inProgressCell.setLabel(Label.THREATEN);
        }
    }

    @Override
    public String toString() {
        return side + "Knight";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Knight knight = new Knight(side);
        knight.row = row;
        knight.cell = (Cell) cell.clone();
        knight.column = column;
        return knight;
    }
}
