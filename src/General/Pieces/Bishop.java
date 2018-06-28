package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
//        ArrayList<Cell> choices = new ArrayList<>();
        Cell current = cell;
        while (current.getUpCell() != null && current.getRightCell() != null) {
            current = current.getUpCell().getRightCell();
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
        while (current.getUpCell() != null && current.getLeftCell() != null) {
            current = current.getUpCell().getLeftCell();
            if (current.isEmpty()) {
                current.setLabel(Label.POSSIBLE);
//                choices.add(current);
            } else {
                if (current.getPiece().side != side) {
//                    choices.add(current);
                    current.setLabel(Label.THREATEN);
                }
                break;
            }

        }
        current = cell;
        while (current.getDownCell() != null && current.getLeftCell() != null) {
            current = current.getDownCell().getLeftCell();
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
        while (current.getDownCell() != null && current.getRightCell() != null) {
            current = current.getDownCell().getRightCell();
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
//        return choices;
    }

    @Override
    public String toString() {
        return side + "Bishop";
    }
}
