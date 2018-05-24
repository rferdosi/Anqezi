package Pieces;

import Board.Side;
import Controllers.Main;
import javafx.scene.image.ImageView;
import Board.Cell;

abstract public class Piece {
    protected ImageView imageView;
    protected Cell cell;
    protected boolean isHited;
    protected Side side;

    public void move(Cell destination) {
        if (!cell.isEmpty()) {
            Main.getPieces().remove(cell.getPiece());
        }
        this.cell = destination;
        cleanTextures();
    }

    public void selected() {
        cleanTextures();
        this.cell.setSelected(true);
    }

    private void cleanTextures() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setPossible(false);
                Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setThreaten(false);
                Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setSelected(false);
            }
        }
    }
}
