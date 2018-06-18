package General.Pieces;

import General.Board.Side;

public class King extends Piece {


    public King(Side side) {
        super(side);
    }

    @Override
    public void selected() {
    super.selected();
        for (int i = -1; i < 2; i++){
            for (int j = -1; j < 2; j++){
                if (i == 0 && j == 0) {
                    continue;
                }
//                else if (Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j) != null) {
//                    if (Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).isEmpty())
//                        Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setPossible(true);
//                    else if (!Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).isEmpty() &&
//                            Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).getPiece().side != this.side) {
//                        Main.board.getCells(this.cell.getRow() + i, this.cell.getColumn() + j).setThreaten(true);
                    }
                }
            }
        }
//    }
//
//}
