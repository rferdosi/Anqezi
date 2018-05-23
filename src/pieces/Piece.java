package pieces;

import javafx.scene.image.ImageView;
import others.Node;

abstract public class Piece {
    private ImageView imageView;
    private Node node;
    private boolean isHited;

    abstract public void move();

    abstract public void clicked();


}
