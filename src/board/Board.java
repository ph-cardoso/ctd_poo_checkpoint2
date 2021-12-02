package board;

import pieces.*;

public class Board {
    private static Board instance;
    private static Piece board[][] = new Piece[8][8];
    private static String auxBoard[][] = new String[8][8];

    private Board() {}

    private static void setInitialBoard() {
        // Clean board putting empty Strings in every position
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Empty(false, i, j);
            }
        }

        // Clean auxBoard putting empty Strings in every position
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                auxBoard[i][j] = " ";
            }
        }

        // White backline
        board[0][0] = new Rook(true, 0, 0);
        board[0][1] = new Knight(true, 0, 1);
        board[0][2] = new Bishop(true, 0, 2);
        board[0][3] = new Queen(true, 0, 3);
        board[0][4] = new King(true, 0, 4);
        board[0][5] = new Bishop(true, 0, 5);
        board[0][6] = new Knight(true, 0, 6);
        board[0][7] = new Rook(true, 0, 7);

        // White Pawns
        board[1][0] = new Pawn(true, 1, 0);
        board[1][1] = new Pawn(true, 1, 1);
        board[1][2] = new Pawn(true, 1, 2);
        board[1][3] = new Pawn(true, 1, 3);
        board[1][4] = new Pawn(true, 1, 4);
        board[1][5] = new Pawn(true, 1, 5);
        board[1][6] = new Pawn(true, 1, 6);
        board[1][7] = new Pawn(true, 1, 7);

        // Black backline
        board[7][0] = new Rook(false, 7, 0);
        board[7][1] = new Knight(false, 7, 1);
        board[7][2] = new Bishop(false, 7, 2);
        board[7][3] = new Queen(false, 7, 3);
        board[7][4] = new King(false, 7, 4);
        board[7][5] = new Bishop(false, 7, 5);
        board[7][6] = new Knight(false, 7, 6);
        board[7][7] = new Rook(false, 7, 7);

        // Black Pawns
        board[6][0] = new Pawn(false, 6, 0);
        board[6][1] = new Pawn(false, 6, 1);
        board[6][2] = new Pawn(false, 6, 2);
        board[6][3] = new Pawn(false, 6, 3);
        board[6][4] = new Pawn(false, 6, 4);
        board[6][5] = new Pawn(false, 6, 5);
        board[6][6] = new Pawn(false, 6, 6);
        board[6][7] = new Pawn(false, 6, 7);
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }

        setInitialBoard();

        return instance;
    }

    public Piece[][] getBoard() {
        return board;
    }

    public String[][] getAuxBoard() {
        return auxBoard;
    }

    public void displayBoard() {
        System.out.printf("\n\n");
        System.out.printf("\t     A   B   C   D   E   F   G   H \n");
        System.out.printf("\t                                   \n");
        System.out.printf("\t 8   %s | %s | %s | %s | %s | %s | %s | %s \n", board[7][0], board[7][1], board[7][2], board[7][3], board[7][4], board[7][5], board[7][6], board[7][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 7   %s | %s | %s | %s | %s | %s | %s | %s \n", board[6][0], board[6][1], board[6][2], board[6][3], board[6][4], board[6][5], board[6][6], board[6][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 6   %s | %s | %s | %s | %s | %s | %s | %s \n", board[5][0], board[5][1], board[5][2], board[5][3], board[5][4], board[5][5], board[5][6], board[5][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 5   %s | %s | %s | %s | %s | %s | %s | %s \n", board[4][0], board[4][1], board[4][2], board[4][3], board[4][4], board[4][5], board[4][6], board[4][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 4   %s | %s | %s | %s | %s | %s | %s | %s \n", board[3][0], board[3][1], board[3][2], board[3][3], board[3][4], board[3][5], board[3][6], board[3][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 3   %s | %s | %s | %s | %s | %s | %s | %s \n", board[2][0], board[2][1], board[2][2], board[2][3], board[2][4], board[2][5], board[2][6], board[2][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 2   %s | %s | %s | %s | %s | %s | %s | %s \n", board[1][0], board[1][1], board[1][2], board[1][3], board[1][4], board[1][5], board[1][6], board[1][7]);
        System.out.printf("\t    -------------------------------\n");
        System.out.printf("\t 1   %s | %s | %s | %s | %s | %s | %s | %s \n\n", board[0][0], board[0][1], board[0][2], board[0][3], board[0][4], board[0][5], board[0][6], board[0][7]);
    }

    public void displayBoardAndMoves() {
        System.out.printf("\n\n");
        System.out.printf("\t     A   B   C   D   E   F   G   H \t\t     A   B   C   D   E   F   G   H \n");
        System.out.printf("\t                                   \t\t                                   \n");
        System.out.printf("\t 8   %s | %s | %s | %s | %s | %s | %s | %s \t\t 8   %s | %s | %s | %s | %s | %s | %s | %s \n", board[7][0], board[7][1], board[7][2], board[7][3], board[7][4], board[7][5], board[7][6], board[7][7], auxBoard[7][0], auxBoard[7][1], auxBoard[7][2], auxBoard[7][3], auxBoard[7][4], auxBoard[7][5], auxBoard[7][6], auxBoard[7][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 7   %s | %s | %s | %s | %s | %s | %s | %s \t\t 7   %s | %s | %s | %s | %s | %s | %s | %s \n", board[6][0], board[6][1], board[6][2], board[6][3], board[6][4], board[6][5], board[6][6], board[6][7], auxBoard[6][0], auxBoard[6][1], auxBoard[6][2], auxBoard[6][3], auxBoard[6][4], auxBoard[6][5], auxBoard[6][6], auxBoard[6][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 6   %s | %s | %s | %s | %s | %s | %s | %s \t\t 6   %s | %s | %s | %s | %s | %s | %s | %s \n", board[5][0], board[5][1], board[5][2], board[5][3], board[5][4], board[5][5], board[5][6], board[5][7], auxBoard[5][0], auxBoard[5][1], auxBoard[5][2], auxBoard[5][3], auxBoard[5][4], auxBoard[5][5], auxBoard[5][6], auxBoard[5][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 5   %s | %s | %s | %s | %s | %s | %s | %s \t\t 5   %s | %s | %s | %s | %s | %s | %s | %s \n", board[4][0], board[4][1], board[4][2], board[4][3], board[4][4], board[4][5], board[4][6], board[4][7], auxBoard[4][0], auxBoard[4][1], auxBoard[4][2], auxBoard[4][3], auxBoard[4][4], auxBoard[4][5], auxBoard[4][6], auxBoard[4][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 4   %s | %s | %s | %s | %s | %s | %s | %s \t\t 4   %s | %s | %s | %s | %s | %s | %s | %s \n", board[3][0], board[3][1], board[3][2], board[3][3], board[3][4], board[3][5], board[3][6], board[3][7], auxBoard[3][0], auxBoard[3][1], auxBoard[3][2], auxBoard[3][3], auxBoard[3][4], auxBoard[3][5], auxBoard[3][6], auxBoard[3][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 3   %s | %s | %s | %s | %s | %s | %s | %s \t\t 3   %s | %s | %s | %s | %s | %s | %s | %s \n", board[2][0], board[2][1], board[2][2], board[2][3], board[2][4], board[2][5], board[2][6], board[2][7], auxBoard[2][0], auxBoard[2][1], auxBoard[2][2], auxBoard[2][3], auxBoard[2][4], auxBoard[2][5], auxBoard[2][6], auxBoard[2][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 2   %s | %s | %s | %s | %s | %s | %s | %s \t\t 2   %s | %s | %s | %s | %s | %s | %s | %s \n", board[1][0], board[1][1], board[1][2], board[1][3], board[1][4], board[1][5], board[1][6], board[1][7], auxBoard[1][0], auxBoard[1][1], auxBoard[1][2], auxBoard[1][3], auxBoard[1][4], auxBoard[1][5], auxBoard[1][6], auxBoard[1][7]);
        System.out.printf("\t    -------------------------------\t\t    -------------------------------\n");
        System.out.printf("\t 1   %s | %s | %s | %s | %s | %s | %s | %s \t\t 1   %s | %s | %s | %s | %s | %s | %s | %s \n\n", board[0][0], board[0][1], board[0][2], board[0][3], board[0][4], board[0][5], board[0][6], board[0][7], auxBoard[0][0], auxBoard[0][1], auxBoard[0][2], auxBoard[0][3], auxBoard[0][4], auxBoard[0][5], auxBoard[0][6], auxBoard[0][7]);
    }
}
