package General.Board;

import ClientSide.Themes.BoardTheme;
import General.Pieces.*;

import java.util.ArrayList;

public class Board {
    private Cell[][] cells = new Cell[8][8];
    private ArrayList<Piece> pieces = new ArrayList<>();
    private BoardTheme theme;

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

    public void deselectAllCells() {
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                String last = cell1.getBoardColour().toString() + "CellSelected";
                cell1.getStyleClass().remove(last);
            }
        }
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
                if (i < 2){
                    side = Side.White;
                }
                else {
                    side = Side.Black;
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
                        if (j == 3) {
                            piece = new King(side);
                        }
                        if (j == 4) {
                            piece = new Queen(side);
                        }
                    }
                    else if (i == 1 || i == 6) {
                        piece = new Pawn(side);
                    }
                    if (piece != null) {
                        piece.setCell(cells[i][j]);
                        piece.setRowAndColumn();
                        pieces.add(piece);
                        cells[i][j].setPiece(piece);
                    }
                }
            }
        }
    }
}
