package pieces;

import Assets.Images.Other.Colour;
import javafx.scene.image.ImageView;
import Board.Cell;

abstract public class Piece {
    protected ImageView imageView;
    protected Cell cell;
    protected boolean isHited;
    protected Colour colour;

    public void move(Cell destination){
        this.cell = destination;
    }

    abstract public void selected();


}
