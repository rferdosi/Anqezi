package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(Side side) {
        super(side);
    }

    @Override
    public void move(Cell destination) {

    }

    @Override
    public ArrayList<Cell> getPossibleChoices() {
        ArrayList<Cell> choices = new ArrayList<>();
        Cell current = cell;
        while (current.getUpCell() != null && current.getRightCell() != null) {
            current = current.getUpCell().getRightCell();
            if (current.isEmpty()) {
                choices.add(current);
                //todo wtf
            } else {
                if (current.getPiece().side != side) {
                    choices.add(current);
                }
                break;
            }
        }
        current = cell;
        while (current.getUpCell() != null && current.getLeftCell() != null) {
            current = current.getUpCell().getLeftCell();
            if (current.isEmpty()) {
                choices.add(current);
            } else {
                if (current.getPiece().side != side) {
                    choices.add(current);
                }
                break;
            }

        }
        current = cell;
        while (current.getDownCell() != null && current.getLeftCell() != null) {
            current = current.getDownCell().getLeftCell();
            if (current.isEmpty()) {
                choices.add(current);
            } else {
                if (current.getPiece().side != side) {
                    choices.add(current);
                }
                break;
            }

        }
        current = cell;
        while (current.getDownCell() != null && current.getRightCell() != null) {
            current = current.getDownCell().getRightCell();
            if (current.isEmpty()) {
                choices.add(current);
            } else {
                if (current.getPiece().side != side) {
                    choices.add(current);
                }
                break;
            }

        }
        return choices;
    }

}
