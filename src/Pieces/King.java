package Pieces;

import Board.Cell;
import Controllers.Main;

public class King extends Piece {

    @Override
    public void move(Cell destination) {

    }

    @Override
    public void selected() {
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).getPiece() != null)
                    Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setPossible(true);
            }
        }
    }

}
