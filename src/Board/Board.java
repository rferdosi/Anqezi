package Board;

import Themes.BoardTheme;

public class Board {
    private Cell[][] cells = new Cell[8][8];
    private BoardTheme theme;

    public Cell getCells(int i, int j) {
        return cells[i][j];
    }

    public BoardTheme getTheme() {
        return theme;
    }

    public void setTheme(BoardTheme theme) {
        this.theme = theme;
    }

    {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell();
                cells[i][j].setColumn(j);
                cells[i][j].setRow(i);
                if ((i + j) % 2 == 0)
                    cells[i][j].setBoardColour(BoardColour.White);
                else
                    cells[i][j].setBoardColour(BoardColour.Black);
            }
        }
//        cells[0][0].setPiece(new Rook());
    }

}
