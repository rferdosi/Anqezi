package pieces;

import javafx.scene.image.ImageView;
import others.Cell;

abstract public class Piece {
    private ImageView imageView;
    private Cell cell;
    private boolean isHited;

    abstract public void move();

    abstract public void selected();


}
