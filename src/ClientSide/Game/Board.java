package ClientSide.Game;

import ClientSide.Client;
import ClientSide.Controllers.GameController;
import ClientSide.Game.Pieces.*;
import General.Side;
import General.User.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Board implements Serializable {
    private Cell[][] cells = new Cell[8][8];
    private ArrayList<Piece> pieces = new ArrayList<>();
    public static Piece lastSelectedPiece;
    public static boolean needToMove;
    public static Player turn;
    private King whiteKing;
    private King blackKing;
    private Game game;
    public String theme = "CopperGolden";


    public Board(Game game) {
        this.game = game;
    }


    public King getBlackKing() {
        return blackKing;
    }

    public King getWhiteKing() {
        return whiteKing;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }


    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Game getGame() {
        return game;
    }

    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell;
                if ((i + j) % 2 == 1) {
                    cell = new Cell(BoardColour.Black);
                } else {
                    cell = new Cell(BoardColour.White);
                }
                cell.setLabel(Label.NORMAL);
                cell.setColumn(j);
                cell.setRow(i);
                cell.setBoard(this);
                cells[i][j] = (cell);
                if (j != 0)
                    cell.setRightCell(cells[i][j - 1]);
                if (i != 0)
                    cell.setUpCell(cells[i - 1][j]);
            }
        }
        addPieces();
    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) {
            if (i < 2 || i > 5) {
                Side side;
                if (i < 2) {
                    side = Side.Black;
                } else {
                    side = Side.White;
                }
                for (int j = 0; j < 8; j++) {
                    Piece piece = null;
                    if (i == 0 || i == 7) {
                        if (j == 0 || j == 7) {
                            piece = new Rook(side);
                        }
                        if (j == 1 || j == 6) {
                            piece = new Knight(side);
                        }
                        if (j == 2 || j == 5) {
                            piece = new Bishop(side);
                        }
                        if (j == 4) {
                            piece = new King(side);
                            switch (side) {
                                case White:
                                    whiteKing = (King) piece;
                                    break;
                                case Black:
                                    blackKing = (King) piece;
                                    break;
                            }
                        }
                        if (j == 3) {
                            piece = new Queen(side);
                        }
                    } else {
                        piece = new Pawn(side);
                    }
                    piece.setCell(cells[i][j]);
                    piece.setRowAndColumn();
                    pieces.add(piece);
                    cells[i][j].setPiece(piece);
                    setTextures(piece);
                }
            }
        }
        updateTextures();
    }

    public void updateTextures() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell = cells[i][j];
                if (!cell.isEmpty()) {
                    setTextures(cell.getPiece());
                    cell.setGraphic(cell.getPiece().getImageView());
                } else {
                    cell.setGraphic(null);
                }
                if (cell.getLabel().equals(Label.POSSIBLE)) {
                    cell.getStyleClass().add(cell.getBoardColour().toString() + "CellPossible");
                } else if (cell.getLabel().equals(Label.THREATEN)) {
                    cell.getStyleClass().add(cell.getBoardColour().toString() + "CellThreaten");
                } else if (cell.getLabel().equals(Label.SELECTED)) {
                    cell.getStyleClass().add(cell.getBoardColour().toString() + "CellSelected");
                }
            }
        }
    }


    public void setTextures(Piece piece) {
        Image image = new Image(getClass().getResource("../../" +
                "ClientSide/Assets/Images/Pieces/" + theme + "/" + piece.toString() + ".png").toExternalForm());
        piece.setImageView(new ImageView(image));
        piece.getImageView().setFitHeight(80);
        piece.getImageView().setFitWidth(80);

    }

    public void cleanTextures() {
        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                cell.getStyleClass().remove(cell.getBoardColour().toString() + "CellPossible");
                cell.getStyleClass().remove(cell.getBoardColour().toString() + "CellSelected");
                cell.getStyleClass().remove(cell.getBoardColour().toString() + "CellThreaten");
                cell.setLabel(Label.NORMAL);
                cell.getStyleClass().add(cell.getBoardColour() + "Cell");
            }
        }
        lastSelectedPiece = null;
    }

    public void changeTurn() throws IOException {
        turn = GameController.otherPlayer;
        Client.oos.writeObject(true);
    }

    public void waitForTurn() throws IOException, ClassNotFoundException {
        while (!turn.equals(GameController.player)) {
            boolean cond = (boolean) Client.ois.readObject();
            if (cond)
                break;
        }
        Board.turn = GameController.player;

    }
}



