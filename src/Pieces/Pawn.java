package Pieces;

import Board.Cell;
import Board.Side;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(Side side) {
        super(side);
    }

    @Override
    public void selected() {
        super.selected();
        if (side == Side.White) {
            if (cell.getUpCell() != null) {
                if (cell.getUpCell().isEmpty()) {
                    cell.getUpCell().setPossible(true);
                    if (isFirstMove) {
                        if (cell.getUpCell().getUpCell().isEmpty()) {
                            cell.getUpCell().getUpCell().setPossible(true);
                        }
                    }
                }
                if (cell.getUpCell().getRightCell() != null && !cell.getUpCell().getRightCell().isEmpty()) {
                    if (cell.getUpCell().getRightCell().getPiece().side != side) {
                        cell.getUpCell().getRightCell().setThreaten(true);
                    }
                }
                if (cell.getUpCell() != null) {
                    if (cell.getUpCell().getLeftCell() != null && !cell.getUpCell().getLeftCell().isEmpty()) {
                        if (cell.getUpCell().getLeftCell().getPiece().side != side) {
                            cell.getUpCell().getLeftCell().setThreaten(true);
                        }
                    }
                }
            }
        } else {
            if (cell.getDownCell() != null) {
                if (cell.getDownCell().isEmpty()) {
                    cell.getDownCell().setPossible(true);
                    if (isFirstMove) {
                        if (cell.getDownCell().getDownCell().isEmpty()) {
                            cell.getDownCell().getDownCell().setPossible(true);
                        }
                    }
                }
                if (cell.getDownCell().getRightCell() != null && !cell.getDownCell().getRightCell().isEmpty()) {
                    if (cell.getDownCell().getRightCell().getPiece().side != side) {
                        cell.getDownCell().getRightCell().setThreaten(true);
                    }
                }

                if (cell.getDownCell().getLeftCell() != null && !cell.getDownCell().getLeftCell().isEmpty()) {
                    if (cell.getDownCell().getLeftCell().getPiece().side != side) {
                        cell.getDownCell().getLeftCell().setThreaten(true);
                    }
                }
            }
        }

    }

    @Override
    public void move(Cell destination) {
        super.move(destination);
        isFirstMove = false;
        if (side == Side.White) {
            if (cell.getRow() == 7)
                queening();
        } else {
            if (cell.getRow() == 0)
                queening();
        }

    }

    private static void queening() {
        //change the pawn to other pieces

    }

}
