package General.Board;

import ClientSide.Themes.BoardTheme;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Board  implements Initializable {
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
