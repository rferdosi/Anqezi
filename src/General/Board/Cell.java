package General.Board;

import ClientSide.Themes.Theme;
import General.Pieces.Piece;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Cell extends Button {
    private Cell upCell;
    private Cell downCell;
    private Cell rightCell;
    private Cell leftCell;

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
            board.deselectAllCells();
            System.out.println(toString());
            this.getStyleClass().add(boardColour.toString() + "CellSelected");
        });
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

//    public void initialize(URL location, ResourceBundle resources) {


//    }

    @Override
    public String toString() {
        String s = boardColour.toString() + " at " + row + " " + column;
        if (piece != null)
            s += "Piece detected!";
        return s;
    }
}

