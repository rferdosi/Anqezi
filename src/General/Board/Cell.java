package General.Board;

import ClientSide.Themes.Theme;
import General.Pieces.Pawn;
import General.Pieces.Piece;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Cell extends Button {
    private Cell upCell;
    private Cell downCell;
    private Cell rightCell;
    private Cell leftCell;
    private boolean isPossible;


    private BoardColour boardColour;

    private int row;
    private int column;
    private ImageView imageView;
    private Piece piece;
    private Theme theme;
    private Board board;


    public BoardColour getBoardColour() {
        return boardColour;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }


    public Cell(BoardColour boardColour) {
        this.boardColour = boardColour;

        this.getStyleClass().add(boardColour.toString() + "Cell");
        super.setPrefSize(100, 100);
        this.setOnAction(event -> {

            if (this.isEmpty()) {
                if (Piece.lastSelectedPiece != null) {

                }
            } else {
                Piece.lastSelectedPiece = piece;
            }
            board.deselectAllCells();
            System.out.println(toString());
            if (!this.isEmpty()) {
                this.getStyleClass().add(boardColour.toString() + "CellSelected");
            }
        });
        if (piece instanceof Pawn) {
//            imageView = new ImageView(getClass().getResourceAsStream("../Assets/Images/Pieces/Carbon/Pawn.png");
        }
//        this.setGraphic(imageView);
//        ().add(imageView);
//        Button button=new Button(" ",imageView)
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    public void setDownCell(Cell downCell) {
        this.downCell = downCell;
        downCell.upCell = this;
    }

    public void setUpCell(Cell upCell) {
        this.upCell = upCell;
    }

    public void setLeftCell(Cell leftCell) {
        this.leftCell = leftCell;
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

    public void setBoardColour(BoardColour boardColour) {
        this.boardColour = boardColour;
    }

    public boolean isEmpty() {
        return (piece == null);
    }

    public boolean isPossible() {
        return isPossible;
    }

    public void setPossible(boolean possible) {
        isPossible = possible;
    }

    @Override
    public String toString() {
        String s = boardColour.toString() + " at " + row + " " + column;
        if (piece != null)
            s += " with " + piece.toString();
        return s;
    }
}

