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
    public ArrayList<Cell> getPossibleChoices() {
        ArrayList<Cell> choices = new ArrayList<>();
        Cell current = cell;
        if (side == Side.White) {
            if (cell.getUpCell() != null) {
                current = cell.getUpCell();
                if (current.isEmpty()) {
                    if (isFirstMove) {
                        if (current.getUpCell().isEmpty()) {
                            choices.add(current.getUpCell());
                        }
                    }
                }
                if (cell.getUpCell().getRightCell() != null && !cell.getUpCell().getRightCell().isEmpty()) {
                    if (cell.getUpCell().getRightCell().getPiece().side != side) {
                        choices.add(cell.getUpCell().getRightCell());
                    }
                }
                if (cell.getUpCell() != null) {
                    if (cell.getUpCell().getLeftCell() != null && !cell.getUpCell().getLeftCell().isEmpty()) {
                        if (cell.getUpCell().getLeftCell().getPiece().side != side) {
                            choices.add(cell.getUpCell().getLeftCell());
                        }
                    }
                }
            }
        } else {
            if (cell.getDownCell() != null) {
                current = cell.getDownCell();
                if (current.isEmpty()) {
                    choices.add(current.getDownCell());
                    if (isFirstMove) {
                        if (current.getDownCell().isEmpty()) {
                            choices.add(current.getDownCell());
                        }
                    }
                }
                if (cell.getDownCell().getRightCell() != null && !cell.getDownCell().getRightCell().isEmpty()) {
                    if (cell.getDownCell().getRightCell().getPiece().side != side) {
                        choices.add(cell.getDownCell().getRightCell());
                    }
                }

                if (cell.getDownCell().getLeftCell() != null && !cell.getDownCell().getLeftCell().isEmpty()) {
                    if (cell.getDownCell().getLeftCell().getPiece().side != side) {
                        choices.add(cell.getDownCell().getLeftCell());
                    }
                }
            }
        }

        return choices;
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

}
