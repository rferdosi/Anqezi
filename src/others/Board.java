package others;

import themes.BoardTheme;

public class Board {
    private Node[][] nodes = new Node[8][8];
    private BoardTheme theme;

    public Node[][] getNodes() {
        return nodes;
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
                nodes[i][j] = new Node();
                if ((i + j) % 2 == 0)
                    nodes[i][j].setSide(Side.White);
                else
                    nodes[i][j].setSide(Side.Black);
            }
        }
    }
}
