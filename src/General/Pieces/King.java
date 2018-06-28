//  ®XxNE0xX

package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;

public class King extends Piece {


    public King(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                    if (isChecked(inProgressCell))
                        continue;
                    if (inProgressCell.isEmpty()) {
                        inProgressCell.setLabel(Label.POSSIBLE);
                    } else if (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side) {
                        inProgressCell.setLabel(Label.THREATEN);
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
    }

    public boolean isChecked(Cell cell) {
        for (Piece piece : this.cell.getBoard().getPieces()) {
            if (piece.side != side) {
                piece.setLabels();
            }
        }
        boolean isChecked = cell.getLabel() == Label.THREATEN;
        cell.getBoard().cleanTextures();
        return isChecked;
    }


    public String toString() {
        return "King";
    }

}
