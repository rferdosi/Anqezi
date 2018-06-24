package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

public class Bishop extends Piece {
    public Bishop(Side side) {
        super(side);
    }

    @Override
    public void move(Cell destination) {

    }

    @Override
    public void getPossibleChoices() {
        super.getPossibleChoices();
        Cell current = cell;
        while (current.getUpCell() != null && current.getRightCell() != null) {
            current = current.getUpCell().getRightCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setThreaten(true);
                }
                break;
            }
        }
        current = cell;
        while (current.getUpCell() != null && current.getLeftCell() != null) {
            current = current.getUpCell().getLeftCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setThreaten(true);
                }
                break;
            }

        }
        current = cell;
        while (current.getDownCell() != null && current.getLeftCell() != null) {
            current = current.getDownCell().getLeftCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setThreaten(true);
                }
                break;
            }

        }
        current = cell;
        while (current.getDownCell() != null && current.getRightCell() != null) {
            current = current.getDownCell().getRightCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setThreaten(true);
                }
                break;
            }

        }
    }

}
