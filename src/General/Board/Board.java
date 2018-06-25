package General.Board;

import ClientSide.Themes.BoardTheme;
import General.Pieces.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Board {
    private Cell[][] cells = new Cell[8][8];
    private ArrayList<Piece> pieces = new ArrayList<>();
    private BoardTheme theme;
    public static Piece lastSelectedPiece;
    public static boolean needToMove;

    public Board() {

    }


    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public BoardTheme getTheme() {
        return theme;
    }

    public void setTheme(BoardTheme theme) {
        this.theme = theme;
    }

    public void cleanTextures() {
        for (Cell[] cells : cells) {
            for (Cell cell : cells) {
                String pos = cell.getBoardColour().toString() + "CellPossible";
                String sel = cell.getBoardColour().toString() + "CellSelected";
                cell.getStyleClass().remove(pos);
                cell.getStyleClass().remove(sel);
                cell.getStyleClass().remove(cell.getBoardColour().toString() + "CellThreaten");

                cell.setPossible(false);
                cell.getStyleClass().add(cell.getBoardColour() + "Cell");
            }
        }
        lastSelectedPiece = null;
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
                if (!cell.isEmpty())
                    cell.setGraphic(cell.getPiece().getImageView());

                if (cell.isPossible()) {
                    if (cell.isEmpty()) {
                        cell.getStyleClass().add(cell.getBoardColour().toString() + "CellPossible");
                    } else {
                        cell.getStyleClass().add(cell.getBoardColour().toString() + "CellThreaten");

                    }
                }
            }
        }

    }

    public void setTextures(Piece piece) {
        Image image = null;
        switch (piece.getSide()) {
            case Black:
                image = new Image(getClass().getResource(
                        "../../ClientSide/Assets/Images/Pieces/Copper/" + piece.toString() + ".png").toExternalForm());
                break;
            case White:
                image = new Image(getClass().getResource
                        ("../../ClientSide/Assets/Images/Pieces/Golden/" + piece.toString() + ".png").toExternalForm());
                break;
        }
        piece.setImageView(new ImageView(image));
//        piece.getImageView().setImage(image);
        piece.getImageView().setFitHeight(80);
        piece.getImageView().setFitWidth(80);
    }
}


