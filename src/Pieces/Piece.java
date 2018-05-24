package Pieces;

import Board.Side;
import javafx.scene.image.ImageView;
import Board.Cell;

abstract public class Piece {
    protected ImageView imageView;
    protected Cell cell;
    protected boolean isHited;
    protected Side side;

    public void move(Cell destination){
        this.cell = destination;
    }

    abstract public void selected();


}
