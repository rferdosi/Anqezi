package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Move;
import General.Board.Side;
import javafx.scene.image.ImageView;

abstract public class Piece {
    protected ImageView imageView;
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
        /*this.cell.setPiece(null);
       // this.cell.setGraphic(null);
        this.cell = destination;
        this.cell.setPiece(this);
      //  this.cell.setGraphic(this.getImageView());
        this.row = destination.getRow();
        this.column = destination.getColumn();*/
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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell myCell = cell.getBoard().getCell(i, j);
                if (myCell.getLabel().equals(Label.THREATEN) || myCell.getLabel().equals(Label.POSSIBLE)) {
                    if (!this.fakeMove(myCell)) {
                        myCell.setLabel(Label.NORMAL);
                    }
                }
            }
        }
    }

    public boolean fakeMove(Cell cell) {
        King king = null;
        switch (side) {
            case Black:
                king = cell.getBoard().getBlackKing();
                break;
            case White:
                king = cell.getBoard().getWhiteKing();
        }
        Cell cellHolder = this.cell;
        Piece pieceHolder = cell.getPiece();
        this.move(cell);
        boolean cond = king.isChecked(king.cell);
        cell.getBoard().cleanTextures();
        return cond;


    }

    @Override
    public String toString() {
        return side.toString() + " ";
    }
}
