package General.Board;

import ClientSide.Controllers.GameController;
import ClientSide.Themes.Theme;
import General.Pieces.Piece;
import javafx.scene.control.Button;

public class Cell extends Button {
    private Cell upCell;
    private Cell downCell;
    private Cell rightCell;
    private Cell leftCell;
    private Label label;


    private BoardColour boardColour;

    private int row;
    private int column;
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
            System.out.println(toString());
            //     ®Powered By rferdosi
            if (Board.isTurn) {
                if (Board.needToMove) {
                    Board.needToMove = false;
//                    board.cleanTextures();
                    if (label.equals(Label.POSSIBLE) || label.equals(Label.THREATEN)) {
                        Board.lastSelectedPiece.move(this);
//                        board.changeTurn();
//                        board.waitForTurn();
                        board.cleanTextures();
                    } else {
                        Board.lastSelectedPiece.getCell().setLabel(Label.NORMAL);
                        Board.needToMove = false;
                        board.cleanTextures();
                    }
                } else {
                    if (piece != null) {
                        if (piece.getSide() == GameController.playerSide) {
                            piece.setLabels();
                            Board.lastSelectedPiece = piece;
                            Board.needToMove = true;
                            setLabel(Label.SELECTED);
                        }
                    } else {
                        board.cleanTextures();
                    }
                }
                board.updateTextures();
            }
        });

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
        upCell.downCell = this;
    }

    public void setLeftCell(Cell leftCell) {
        this.leftCell = leftCell;
        leftCell.rightCell = this;
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


    public void setBoardColour(BoardColour boardColour) {
        this.boardColour = boardColour;
    }

    public boolean isEmpty() {
        return (piece == null);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public String toString() {
        String s = boardColour.toString() + " at " + row + " " + column;
        if (piece != null)
            s += " with " + piece.toString();
        return s;
    }
}

