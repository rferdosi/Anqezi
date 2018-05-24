package Pieces;

import Board.Cell;

public class Rock extends Piece {
    @Override
    public void selected() {
        super.selected();
        Cell current = cell;
        while (current.getUpCell() != null) {
            current = current.getUpCell();
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
        while (current.getDownCell() != null) {
            current = current.getDownCell();
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
        while (current.getRightCell() != null) {
            current = current.getRightCell();
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
        while (current.getLeftCell() != null) {
            current = current.getLeftCell();
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
