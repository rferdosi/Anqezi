package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Side side) {
        super(side);
    }

    @Override
    public void getPossibleChoices() {
        Cell current = cell;
        while (current.getUpCell() != null) {
            current = current.getUpCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setPossible(true);
                }
                break;
            }
        }
        current = cell;
        while (current.getDownCell() != null) {
            current = current.getDownCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setPossible(true);
                }
                break;
            }
        }
        current = cell;
        while (current.getRightCell() != null) {
            current = current.getRightCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setPossible(true);
                }
                break;
            }
        }
        current = cell;
        while (current.getLeftCell() != null) {
            current = current.getLeftCell();
            if (current.isEmpty()) {
                current.setPossible(true);
            } else {
                if (current.getPiece().side != side) {
                    current.setPossible(true);
                }
                break;
            }
        }
    }

}
