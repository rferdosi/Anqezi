//  ®XxNE0xX

package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;

import java.util.ArrayList;

public class King extends Piece {
    private boolean isFirstMove;


    public King(Side side) {
        super(side);
    }

    {
        isFirstMove = true;
    }

    @Override
    public void setLabels() {
        ArrayList<Cell> posCells = new ArrayList<>();
        ArrayList<Cell> trtCells = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                    if (isChecked(inProgressCell)) {
                        continue;
                    }
                    if (inProgressCell.isEmpty()) {
                        posCells.add(inProgressCell);
//                        inProgressCell.setLabel(Label.POSSIBLE);
                    } else if (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side) {
                        trtCells.add(inProgressCell);
//                        inProgressCell.setLabel(Label.THREATEN);
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
                if (isFirstMove) {
                    if (cell.getLeftCell().isEmpty() && cell.getLeftCell().getLeftCell().isEmpty()) {
                        cell.getLeftCell().getLeftCell().getLeftCell().setLabel(Label.POSSIBLE);
                    }
                    if (cell.getRightCell().isEmpty() && cell.getRightCell().getRightCell().isEmpty() &&
                            cell.getRightCell().getRightCell().getRightCell().isEmpty()
                            ) {
                        cell.getRightCell().getRightCell().getRightCell().getRightCell().setLabel(Label.POSSIBLE);
                    }
                }
            }
        }
        for (Cell posCell : posCells) {
            posCell.setLabel(Label.POSSIBLE);
        }
        for (Cell trtCell : trtCells) {
            trtCell.setLabel(Label.THREATEN);
        }
    }

    public boolean isChecked(Cell cell) {
        King fakeKing = new King(side);
        Piece lastPiece = cell.getPiece();
        cell.setPiece(fakeKing);
        for (Piece piece : this.cell.getBoard().getPieces()) {
            if (piece.side != side) {
                if (piece instanceof King)
                    continue;
                piece.setLabels();

            }
        }

        boolean isChecked = cell.getLabel().equals(Label.THREATEN);
        cell.setPiece(lastPiece);
        cell.getBoard().cleanTextures();
        return isChecked;
    }


    public String toString() {
        return side + "King";
    }

    @Override
    public void move(Cell destination) {
        super.move(destination);
        isFirstMove = false;
    }
}
