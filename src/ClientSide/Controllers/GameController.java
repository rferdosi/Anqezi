package ClientSide.Controllers;

import General.Board.BoardColour;
import General.Board.Cell;
import General.Board.Side;
import General.Pieces.Pawn;
import General.Pieces.Piece;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController extends MotherController implements Initializable {

    public VBox myBoard;
    public Cell[][] board;
    public ArrayList<Piece> pieces;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myBoard.setSpacing(-15);
        if (board == null)
            newBoard();


    }

    private void newBoard() {
        board = new Cell[8][8];
        ObservableList<Node> children = myBoard.getChildren();
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            HBox hBox = (HBox) node;
            for (int j = 0; j < 8; j++) {
                Cell cell;
                if ((i + j) % 2 == 0) {
                    hBox.getChildren().add(cell = new Cell(BoardColour.Black));
                } else {
                    hBox.getChildren().add(cell = new Cell(BoardColour.White));
                }
                board[i][j] = (cell);
                cell.setColumn(j);
                cell.setRow(i);
                if (j != 0)
                    cell.setRightCell(board[i][j - 1]);
                if (i != 0)
                    cell.setUpCell(board[i - 1][j]);
            }
        }
        addPieces();

    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = null;
                pieces.add(piece);
                switch (i) {
                    case 6:
                        piece = new Pawn(Side.White);
                        break;
                    case 2:
                        piece = new Pawn(Side.Black);
                        break;
                }
                board[i][j].setPiece(piece);
            }
        }

    }
}
