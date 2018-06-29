package ClientSide.Game.Pieces;

import ClientSide.Game.Cell;
import ClientSide.Game.Label;
import General.Side;

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
        super.setLabels();
//        return choices;
    }

    @Override
    public String toString() {
        return side + "Bishop";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Bishop bishop = new Bishop(side);
        bishop.row = row;
        bishop.column = column;
        bishop.cell = (Cell) cell.clone();
        return bishop;
    }
}
