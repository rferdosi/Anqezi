package Board;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import pieces.Piece;

public class Cell extends Button {
    private Cell upCell;
    private Cell downCell;
    private Cell rightCell;
    private Cell leftCell;
    private Colour colour;
    private int row;
    private int column;
    private ImageView imageView;
    private Piece piece;

    {
//        super.setWidth(60);
//        super.setHeight(60);
        super.setPrefSize(75,75);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

//    @Override
//    protected void setWidth(double value) {
//        super.setWidth(value);
//    }

    public void setDownCell(Cell downCell) {
        this.downCell = downCell;
        downCell.upCell = this;
    }

    public void setRightCell(Cell rightCell) {
        this.rightCell = rightCell;
        rightCell.leftCell = this;
    }

    public Cell getUpCell() {
        return upCell;
    }

    public Cell getDownCell() {
        return downCell;
    }

    public Cell getRightCell() {
        return rightCell;
    }

    public Cell getLeftCell() {
        return leftCell;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int i) {
        this.row = i;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int j) {
        this.column = j;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }
}

