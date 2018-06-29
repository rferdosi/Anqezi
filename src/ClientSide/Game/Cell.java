package ClientSide.Game;

import ClientSide.Controllers.GameController;
import ClientSide.Game.Pieces.King;
import ClientSide.Themes.Theme;
import ClientSide.Game.Pieces.Piece;
import General.Side;
import javafx.scene.control.Button;

import java.io.IOException;
import java.io.Serializable;

public class Cell extends Button implements Cloneable, Serializable {
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
//            System.out.println(toString());
            //     ®Powered By rferdosi
            if (GameController.isTurn && GameController.game.isPlayer2Accepted()) {
                if (Board.needToMove) {
                    Board.needToMove = false;
                    if (label.equals(Label.POSSIBLE) || label.equals(Label.THREATEN)) {
                        if (!isEmpty() && Board.lastSelectedPiece.getSide().equals(piece.getSide())) {  // Castling
                            if (Board.lastSelectedPiece.getCell().leftCell.leftCell.leftCell.equals(this)) {
                                Board.lastSelectedPiece.move(this.rightCell);
                                this.getPiece().move(Board.lastSelectedPiece.getCell().rightCell);
                            } else {
                                Board.lastSelectedPiece.move(Board.lastSelectedPiece.getCell().rightCell.rightCell);
                                piece.move(Board.lastSelectedPiece.getCell().leftCell);
                            }
                        } else {
                            Board.lastSelectedPiece.move(this);
                            System.out.println(board.getBlackKing().isChecked(board.getBlackKing().getCell()));
                        }
                        try {
                            board.changeTurn();
                            board.cleanTextures();
                            board.waitForTurn();
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }

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


    public boolean isCheckedByOtherKing(Side side) {
        King king = null;
        switch (side) {
            case White:
                king = getBoard().getBlackKing();
                break;
            case Black:
                king = getBoard().getWhiteKing();
                break;
        }
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                try {
                    if (getBoard().getCell(row + i, column + j).getPiece().equals(king)) {
                        return true;
                    }

                } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
                    System.out.println("Index");
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = boardColour.toString() + " at " + row + " " + column;
        if (piece != null)
            s += " with " + piece.toString();
        return s;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Cell tmp = new Cell(this.boardColour);
        Piece myPiece = (Piece) piece.clone();
        tmp.setPiece(myPiece);
        return tmp;
    }

}

