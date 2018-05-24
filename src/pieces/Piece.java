package pieces;

import javafx.scene.image.ImageView;
import Board.Cell;

abstract public class Piece {
    private ImageView imageView;
    private Cell cell;
    private boolean isHited;

    public void move(Cell destination){
        this.cell = destination;
    }

    abstract public void selected();


}
