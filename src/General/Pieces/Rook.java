package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
        Cell current = cell;
        while (current.getUpCell() != null) {
            current = current.getUpCell();
            if (current.isEmpty()) {
//                choices.add(current);
                current.setLabel(Label.POSSIBLE);
            } else {
                if (current.getPiece().side != side) {
                    current.setLabel(Label.THREATEN);
//                    choices.add(current);
                }
                break;
            }
        }
        current = cell;
        while (current.getDownCell() != null) {
            current = current.getDownCell();
            if (current.isEmpty()) {
//                choices.add(current);
                current.setLabel(Label.POSSIBLE);
            } else {
                if (current.getPiece().side != side) {
                    current.setLabel(Label.THREATEN);
//                    choices.add(current);
                }
                break;
            }
        }
        current = cell;
        while (current.getRightCell() != null) {
            current = current.getRightCell();
            if (current.isEmpty()) {
//                choices.add(current);
                current.setLabel(Label.POSSIBLE);
            } else {
                if (current.getPiece().side != side) {
//                    choices.add(current);
                    current.setLabel(Label.THREATEN);
                }
                break;
            }
        }
        current = cell;
        while (current.getLeftCell() != null) {
            current = current.getLeftCell();
            if (current.isEmpty()) {
//                choices.add(current);
                current.setLabel(Label.POSSIBLE);
            } else {
                if (current.getPiece().side != side) {
//                    choices.add(current);
                    current.setLabel(Label.THREATEN);
                }
                break;
            }
        }
        super.setLabels();
    }

    @Override
    public String toString() {
        return side + "Rook";
    }
}
