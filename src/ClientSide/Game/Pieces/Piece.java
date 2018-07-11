package ClientSide.Game.Pieces;

import ClientSide.Game.*;
import General.Side;
import javafx.scene.image.ImageView;

import java.io.Serializable;

abstract public class Piece implements Cloneable, Serializable {
    private static final long serialVersionUID = 123456785;
    transient protected ImageView imageView;
    protected Cell cell;
    protected Side side;
    protected int row;

    public void setRowAndColumn() {
        row = this.cell.getRow();
        column = this.cell.getColumn();
    }

    protected int column;

    public Piece(Side side) {
        this.side = side;
    }

    public void move(Cell destination) {
        if (!destination.isEmpty() && destination.getPiece().side != this.side) {
            this.cell.getBoard().getPieces().remove(destination.getPiece());
        }
        Move move = new Move(this, cell, destination);
        cell.getBoard().getGame().getMoves().add(move);
        cell.setPiece(null);
        cell = destination;
        cell.setPiece(this);
        row = destination.getRow();
        column = destination.getColumn();
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }


    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public Side getSide() {
        return side;
    }

    public void setLabels() {
//        King king = null;
//        switch (side) {
//            case Black:
//                king = cell.getBoard().getBlackKing();
//                break;
//            case White:
//                king = cell.getBoard().getWhiteKing();
//        }
//        Cell[][] cells = cell.getBoard().getCells();
//        Cell cellHolder = cell;
//        cell = null;

//        Cell[][] fakeCells = cell.getBoard().getCells().clone();
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Cell myCell = fakeCells[i][j];
//                if (myCell.getLabel().equals(Label.THREATEN) || myCell.getLabel().equals(Label.POSSIBLE)) {
//                    if (!(this instanceof King))
//                        if (!this.fakeMove(myCell)) {
//                            myCell.setLabel(Label.NORMAL);
//                        }
//                }
//            }
//        }
    }

    private boolean fakeMove(Cell cell) {
//
//        Cell cellHolder = this.cell;
//        Piece pieceHolder = cell.getPiece();
//        this.move(cell);
//        boolean cond = king.isChecked(king.cell);
//        this.move(cellHolder);
//        pieceHolder.move(cell);
//        cell.getBoard().cleanTextures();
////        return cond;
        return false;

    }

    @Override
    public String toString() {
        return side.toString() + " ";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
