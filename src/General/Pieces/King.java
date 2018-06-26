//  ®XxNE0xX

package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class King extends Piece {

    private boolean checked;

    public King(Side side) {
        super(side);
    }

    @Override
    public ArrayList<Cell> getPossibleChoices() {
        ArrayList<Cell> choices = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                try {
                    Cell inProgressCell = this.cell.getBoard().getCell(row + i, column + j);
                    if (inProgressCell.isEmpty() ||
                            (!inProgressCell.isEmpty() && inProgressCell.getPiece().side != this.side)) {
                        choices.add(inProgressCell);
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return choices;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String toString() {
        return "King";
    }

}
