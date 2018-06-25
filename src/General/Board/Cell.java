package General.Board;

import ClientSide.Themes.Theme;
import General.Pieces.Piece;
import javafx.scene.control.Button;

public class Cell extends Button {
    private Cell upCell;
    private Cell downCell;
    private Cell rightCell;
    private Cell leftCell;
    private boolean isPossible;


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
//      ®Powered By XxNE0XX!
            board.updateTextures();
            System.out.println(getText());
            if (Board.lastSelectedPiece != null) {
                if (isPossible) {
                    Board.lastSelectedPiece.move(this);
                    Board.lastSelectedPiece = null;
                    board.updateTextures();
                    board.deselectAllCells();
                } else if (!isPossible() && !isEmpty()) {
                    board.deselectAllCells();
                    Board.lastSelectedPiece = this.getPiece();
                    this.getPiece().getPossibleChoices();
                }
            } else if (Board.lastSelectedPiece == null && !isEmpty()) {
                //board.deselectAllCells();
                Board.lastSelectedPiece = this.getPiece();
                this.getPiece().getPossibleChoices();
            } else {
                board.deselectAllCells();
                Board.lastSelectedPiece = null;
            }

            System.out.println(toString());
            if (!this.isEmpty()) {
                this.getStyleClass().add(boardColour.toString() + "CellSelected");
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    Cell cell = board.getCell(i, j);
                    cell.getStyleClass().clear();
                    if (cell.isPossible() && cell.isEmpty()) {
                        //cell.getStyleClass().remove(boardColour.toString() + "Cell");
                        cell.getStyleClass().add(boardColour.toString() + "CellPossible");
                        System.out.println(cell.toString());
                    } else if (cell.isPossible() && !cell.isEmpty()) {
                        //cell.getStyleClass().remove(boardColour.toString() + "Cell");
                        // TODO: 06/24/18 Reza add threaten here!
                        cell.getStyleClass().add(boardColour.toString() + "CellThreaten");
                    }
                    else {
                        cell.getStyleClass().add(cell.getBoardColour().toString() + "Cell");
                    }
                }
            }
//            board.updateTextures();
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

