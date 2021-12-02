package pieces;

import board.Board;

public abstract class Piece {
    private boolean isWhite;
    private int posX;
    private int posY;

    public Piece(boolean isWhite, int posX, int posY) {
        this.isWhite = isWhite;
        this.posX = posX;
        this.posY = posY;
    }

    public static int columnToInt(char column){
        switch(column) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            case 'D':
                return 3;
            case 'E':
                return 4;
            case 'F':
                return 5;
            case 'G':
                return 6;
            case 'H':
                return 7;
            default:
                return -1;
        }
    }

    public static void zerarMoves(String[][] auxBoard) {
        //Preenchendo todas as casas com uma string vazia.
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                auxBoard[i][j] = " ";
            }
        }
    }

    // Getters and Setters
    public boolean isWhite() {
        return this.isWhite;
    }

    public int getPosX() {
        return this.posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    // Abstract Methods
    public abstract int showValidMoves(Piece[][] board, String[][] auxBoard);
    public abstract int[] getUserPlayChoice(Piece[][] board, String[][] auxBoard);
    public abstract void move(Piece[][] board, int x, int y);
    public abstract void moveOperation(Board boardInstace, Piece[][] board, String[][] auxBoard);
    public abstract String toString();
}