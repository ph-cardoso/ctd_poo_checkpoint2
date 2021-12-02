package pieces;

import board.Board;

public class Empty extends Piece {

    public Empty(boolean isWhite, int posX, int posY) {
        super(false, posX, posY);
    }

    @Override
    public String toString() {
        return " ";
    }

    public int showValidMoves(Piece[][] board, String[][] auxBoard){return -1;};
    public int[] getUserPlayChoice(Piece[][] board, String[][] auxBoard){return new int[]{-1, -1};};
    public void move(Piece[][] board, int x, int y){};
    public void moveOperation(Board boardInstance, Piece[][] board, String[][] auxBoard){};
}
