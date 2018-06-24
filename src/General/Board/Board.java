package General.Board;

import ClientSide.Themes.BoardTheme;
import General.Pieces.Pawn;
import General.Pieces.Piece;

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

    public BoardTheme getTheme() {
        return theme;
    }

    public void setTheme(BoardTheme theme) {
        this.theme = theme;
    }

    public void deselectAllCells() {
        for (Cell[] cell : cells) {
            for (Cell cell1 : cell) {
                cell1.setSelected(false);
                String last = cell1.getBoardColour().toString() + "CellSelected";
//                String next = cell1.getBoardColour().toString() + "Cell";
                cell1.getStyleClass().remove(last);
//                cell1.getStyleClass().add(next);
//                System.out.println(last);
//                System.out.println(next);
            }
        }
    }

    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell cell;
                if ((i + j) % 2 == 0) {
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
//        addPieces();
    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = null;
                switch (i) {
                    case 6:
                        piece = new Pawn(Side.White);
                        break;
                    case 2:
                        piece = new Pawn(Side.Black);
                        break;
                }
                if (piece != null) {
                    pieces.add(piece);
                    cells[i][j].setPiece(piece);
                }
            }
        }
    }
}
