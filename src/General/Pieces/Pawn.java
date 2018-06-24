package General.Pieces;

import General.Board.Cell;
import General.Board.Side;

import java.util.ArrayList;

public class Pawn extends Piece {
    private boolean isFirstMove = true;

    public Pawn(Side side) {
        super(side);
    }

    @Override
    public void getPossibleChoices() {
        Cell current;
        if (side == Side.White) {
            if (cell.getUpCell() != null) {
                current = cell.getUpCell();
                if (current.isEmpty()) {
                    current.setPossible(true);
                    if (isFirstMove) {
                        if (current.getUpCell().isEmpty()) {
                            current.getUpCell().setPossible(true);
                        }
                    }
                }
                if (cell.getUpCell().getRightCell() != null && !cell.getUpCell().getRightCell().isEmpty()) {
                    if (cell.getUpCell().getRightCell().getPiece().side != side) {
                        cell.getUpCell().getRightCell().setPossible(true);
                    }
                }
                if (cell.getUpCell() != null) {
                    if (cell.getUpCell().getLeftCell() != null && !cell.getUpCell().getLeftCell().isEmpty()) {
                        if (cell.getUpCell().getLeftCell().getPiece().side != side) {
                            cell.getUpCell().getLeftCell().setPossible(true);
                        }
                    }
                }
            }
        } else {
            if (cell.getDownCell() != null) {
                current = cell.getDownCell();
                if (current.isEmpty()) {
                    current.setPossible(true);
                    current.getDownCell().setPossible(true);
                    if (isFirstMove) {
                        if (current.getDownCell().isEmpty()) {
                            current.getDownCell().setPossible(true);
                        }
                    }
                }
                if (cell.getDownCell().getRightCell() != null && !cell.getDownCell().getRightCell().isEmpty()) {
                    if (cell.getDownCell().getRightCell().getPiece().side != side) {
                        cell.getDownCell().getRightCell().setPossible(true);
                    }
                }

                if (cell.getDownCell().getLeftCell() != null && !cell.getDownCell().getLeftCell().isEmpty()) {
                    if (cell.getDownCell().getLeftCell().getPiece().side != side) {
                        cell.getDownCell().getLeftCell().setPossible(true);
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
        //todo change the pawn to other pieces

    }

    @Override
    public String toString() {
        return super.toString() + "Pawn";
    }
}
