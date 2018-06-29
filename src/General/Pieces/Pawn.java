package General.Pieces;

import General.Board.Cell;
import General.Board.Label;
import General.Board.Side;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Optional;

public class Pawn extends Piece {
    private boolean isFirstMove = true;
    Cell nextToLast;

    public Pawn(Side side) {
        super(side);
    }

    @Override
    public void setLabels() {
        Cell current;
        if (side == Side.White) {
            if (cell.getUpCell() != null) {
                current = cell.getUpCell();
                if (current.isEmpty()) {
//                    choices.add(current);
                    current.setLabel(Label.POSSIBLE);
                    if (isFirstMove) {
                        if (current.getUpCell().isEmpty()) {
//                            choices.add(current.getUpCell());
                            current.getUpCell().setLabel(Label.POSSIBLE);
                        }
                    }
                }
                if (cell.getUpCell().getRightCell() != null && !cell.getUpCell().getRightCell().isEmpty()) {
                    if (cell.getUpCell().getRightCell().getPiece().side != side) {
//                        choices.add(cell.getUpCell().getRightCell());
                        cell.getUpCell().getRightCell().setLabel(Label.THREATEN);
                    }
                }
                if (cell.getUpCell() != null) {
                    if (cell.getUpCell().getLeftCell() != null && !cell.getUpCell().getLeftCell().isEmpty()) {
                        if (cell.getUpCell().getLeftCell().getPiece().side != side) {
//                            choices.add(cell.getUpCell().getLeftCell());
                            cell.getUpCell().getLeftCell().setLabel(Label.THREATEN);
                        }
                    }
                }
            }
        } else {
            if (cell.getDownCell() != null) {
                current = cell.getDownCell();
                if (current.isEmpty()) {
//                    choices.add(current);
                    current.setLabel(Label.POSSIBLE);
                    if (isFirstMove) {
                        if (current.getDownCell().isEmpty()) {
//                            choices.add(current.getDownCell());
                            current.getDownCell().setLabel(Label.POSSIBLE);
                        }
                    }
                }
                if (cell.getDownCell().getRightCell() != null && !cell.getDownCell().getRightCell().isEmpty()) {
                    if (cell.getDownCell().getRightCell().getPiece().side != side) {
//                        choices.add(cell.getDownCell().getRightCell());
                        cell.getDownCell().getRightCell().setLabel(Label.THREATEN);
                    }
                }

                if (cell.getDownCell().getLeftCell() != null && !cell.getDownCell().getLeftCell().isEmpty()) {
                    if (cell.getDownCell().getLeftCell().getPiece().side != side) {
//                        choices.add(cell.getRightCell().getLeftCell());
                        cell.getDownCell().getLeftCell().setLabel(Label.THREATEN);
                    }
                }
            }
        }
//        return choices;
        super.setLabels();
    }

    @Override
    public void move(Cell destination) {

        super.move(destination);

        isFirstMove = false;
        if (side == Side.White) {
            if (cell.getRow() == 0) {
                nextToLast.setPiece(null);
                cell.getBoard().cleanTextures();
                queening();
            }
        } else {
            if (cell.getRow() == 7) {
                nextToLast.setPiece(null);
                cell.getBoard().cleanTextures();
                queening();
            }
        }

        try {
            System.out.println(nextToLast.toString());
        } catch (NullPointerException e) {
            System.out.println("Not Initialized yet!");
        }

        nextToLast = this.cell;

    }

    private void queening() {

        String askedPiece = queeningAlert();

        this.cell.getBoard().getPieces().remove(this);
        cell.getBoard().cleanTextures();

        Piece piece;

        if (askedPiece.equals("Bishop")) {
            piece = new Bishop(side);
        } else if (askedPiece.equals("Queen")) {
            piece = new Queen(side);
        } else if (askedPiece.equals("Rook")) {
            piece = new Rook(side);
        } else {
            piece = new Knight(side);
        }

        piece.cell = this.cell;
        this.cell.setPiece(piece);
        piece.setRowAndColumn();
        this.cell.getBoard().getPieces().add(piece);
        nextToLast.setGraphic(null);
        this.cell.getBoard().setTextures(piece);
    }

    private String queeningAlert() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.initStyle(StageStyle.UNDECORATED);
        dialog.getDialogPane().setPrefSize(480, 320);
        dialog.setHeaderText("Choose Your Piece!");

        DialogPane dialogPane = dialog.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../../ClientSide/CSS/game.css").toExternalForm());
        dialogPane.getStyleClass().add("queeningDialog");

        ButtonType buttonTypeBishop = new ButtonType("Bishop");
        ButtonType buttonTypeQueen = new ButtonType("Queen");
        ButtonType buttonTypeRook = new ButtonType("Rook");
        ButtonType buttonTypeKnight = new ButtonType("Knight");


        dialog.getButtonTypes().setAll(buttonTypeBishop, buttonTypeQueen, buttonTypeRook, buttonTypeKnight);

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.get() == buttonTypeBishop) {
            return "Bishop";
        } else if (result.get() == buttonTypeQueen) {
            return "Queen";
        } else if (result.get() == buttonTypeRook) {
            return "Rook";
        } else {
            return "Knight";
        }
    }

    @Override
    public String toString() {
        return side + "Pawn";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Pawn pawn = new Pawn(side);
        pawn.cell = (Cell) cell.clone();
        pawn.column = column;
        pawn.row = row;
        return pawn;
    }
}
