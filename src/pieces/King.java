package pieces;

import java.util.Scanner;
import utils.ConsoleColors;
import board.Board;

public class King extends Piece {
    Scanner sc = new Scanner(System.in);

    public King(boolean isWhite, int posX, int posY) {
        super(isWhite, posX, posY);
    }

    @Override
    public String toString() {
        String content = "";
        if(super.isWhite()){
            content += ConsoleColors.WHITE_BOLD_BRIGHT;
            content += "K";
            content += ConsoleColors.RESET;
            return content;
        } else {
            content += ConsoleColors.RED_BOLD_BRIGHT;
            content += "K";
            content += ConsoleColors.RESET;
            return content;
        }
    }

    @Override
    public int showValidMoves(Piece[][] board, String[][] auxBoard){
        int dir1 = 0;
        int dir2 = 0;
        int dir3 = 0;
        int dir4 = 0;
        int dir5 = 0;
        int dir6 = 0;
        int dir7 = 0;
        int dir8 = 0;

        int possiblePlays = 0;

        auxBoard[super.getPosX()][super.getPosY()] = this.toString();

        if(this.isWhite()){
            if(super.getPosX() != 0){
                if(board[super.getPosX() - 1][super.getPosY()].toString().equals(" ")) //Superior
                    dir1++;
                else
                {
                    if(!board[super.getPosX() - 1][super.getPosY()].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY()] = board[super.getPosX() - 1][super.getPosY()].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir1 != 0){
                auxBoard[super.getPosX() - 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 0 && getPosY() != 7){
                if(board[super.getPosX() - 1][super.getPosY() + 1].toString().equals(" ")) //Diagonal superior direita
                    dir2++;
                else
                {
                    if(!board[super.getPosX() - 1][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY() + 1] = board[super.getPosX() - 1][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir2 != 0){
				auxBoard[super.getPosX() - 1][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 0 && getPosY() != 0){
                if(board[super.getPosX() - 1][super.getPosY() - 1].toString().equals(" ")) //Diagonal superior esquerda
                    dir3++;
                else
                {
                    if(!board[super.getPosX() - 1][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY() - 1] = board[super.getPosX() - 1][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }


			if(dir3 != 0){
				auxBoard[super.getPosX() - 1][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosY() != 7){
                if(board[super.getPosX()][super.getPosY() + 1].toString().equals(" ")) //Direita
                    dir4++;
                else
                {
                    if(!board[super.getPosX()][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX()][super.getPosY() + 1] = board[super.getPosX()][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir4 != 0){
				auxBoard[super.getPosX()][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosY() != 0){
                if(board[super.getPosX()][super.getPosY() - 1].toString().equals(" ")) //Esquerda
                    dir5++;
                else
                {
                    if(!board[super.getPosX()][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX()][super.getPosY() - 1] = board[super.getPosX()][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir5 != 0){
				auxBoard[super.getPosX()][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7 && getPosY() != 0){
                if(board[super.getPosX() + 1][super.getPosY() - 1].toString().equals(" ")) //Diagonal Inferior esquerda
                    dir6++;
                else
                {
                    if(!board[super.getPosX() + 1][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY() - 1] = board[super.getPosX() + 1][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir6 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7 && getPosY() != 7){
                if(board[super.getPosX() + 1][super.getPosY() + 1].toString().equals(" ")) //Diagonal inferior direita
                    dir7++;
                else
                {
                    if(!board[super.getPosX() + 1][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY() + 1] = board[super.getPosX() + 1][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir7 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7){
                if(board[super.getPosX() + 1][super.getPosY()].toString().equals(" ")) //Inferior
                    dir8++;
                else
                {
                    if(!board[super.getPosX() + 1][super.getPosY()].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY()] = board[super.getPosX() + 1][super.getPosY()].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir8 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }
        } else {
            if(super.getPosX() != 0){
                if(board[super.getPosX() - 1][super.getPosY()].toString().equals(" ")) //Superior
                    dir1++;
                else
                {
                    if(board[super.getPosX() - 1][super.getPosY()].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY()] = board[super.getPosX() - 1][super.getPosY()].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir1 != 0){
                auxBoard[super.getPosX() - 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 0 && getPosY() != 7){
                if(board[super.getPosX() - 1][super.getPosY() + 1].toString().equals(" ")) //Diagonal superior direita
                    dir2++;
                else
                {
                    if(board[super.getPosX() - 1][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY() + 1] = board[super.getPosX() - 1][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir2 != 0){
				auxBoard[super.getPosX() - 1][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 0 && getPosY() != 0){
                if(board[super.getPosX() - 1][super.getPosY() - 1].toString().equals(" ")) //Diagonal superior esquerda
                    dir3++;
                else
                {
                    if(board[super.getPosX() - 1][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX() - 1][super.getPosY() - 1] = board[super.getPosX() - 1][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir3 != 0){
				auxBoard[super.getPosX() - 1][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosY() != 7){
                if(board[super.getPosX()][super.getPosY() + 1].toString().equals(" ")) //Direita
                    dir4++;
                else
                {
                    if(board[super.getPosX()][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX()][super.getPosY() + 1] = board[super.getPosX()][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir4 != 0){
				auxBoard[super.getPosX()][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosY() != 0){
                if(board[super.getPosX()][super.getPosY() - 1].toString().equals(" ")) //Esquerda
                    dir5++;
                else
                {
                    if(board[super.getPosX()][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX()][super.getPosY() - 1] = board[super.getPosX()][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir5 != 0){
				auxBoard[super.getPosX()][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7 && getPosY() != 0){
                if(board[super.getPosX() + 1][super.getPosY() - 1].toString().equals(" ")) //Diagonal Inferior esquerda
                    dir6++;
                else
                {
                    if(board[super.getPosX() + 1][super.getPosY() - 1].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY() - 1] = board[super.getPosX() + 1][super.getPosY() - 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir6 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY() - 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7 && getPosY() != 7){
                if(board[super.getPosX() + 1][super.getPosY() + 1].toString().equals(" ")) //Diagonal inferior direita
                    dir7++;
                else
                {
                    if(board[super.getPosX() + 1][super.getPosY() + 1].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY() + 1] = board[super.getPosX() + 1][super.getPosY() + 1].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir7 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY() + 1] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }

            if(getPosX() != 7){
                if(board[super.getPosX() + 1][super.getPosY()].toString().equals(" ")) //Inferior
                    dir8++;
                else
                {
                    if(board[super.getPosX() + 1][super.getPosY()].isWhite())
                    {
                        auxBoard[super.getPosX() + 1][super.getPosY()] = board[super.getPosX() + 1][super.getPosY()].toString();
                        possiblePlays++;
                    }
                }
            }

			if(dir8 != 0){
				auxBoard[super.getPosX() + 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
            }
        }

        return possiblePlays;
    }

    @Override
    public int[] getUserPlayChoice(Piece[][] board, String[][] auxBoard){
        int[] choice = new int[2];
        int x = 0;
        int y = 0;
        int errorColumnCounter = 0;
        char inputY = ' ';

        do{
            System.out.printf("\n\tSelecione o local que vai receber a jogada: ");
            // Input da linha
            do {
                System.out.printf("\n\tNúmero Linha: ");
                x = sc.nextInt() - 1;

                if(x < 0 || x > 7){
                    System.out.printf("\n\tLinha inválida, tente novamente...");
                }
            } while(x < 0 || x > 7);

            // Input da coluna
            do {
                System.out.printf("\tLetra Coluna: ");

                if(errorColumnCounter == 0){
                    sc.nextLine(); // Clear input buffer
                }

                inputY = sc.nextLine().toUpperCase().charAt(0);

                if(columnToInt(inputY) == -1){
                    System.out.printf("\n\tColuna inválida, tente novamente...\n");
                    errorColumnCounter++;
                }

                y = columnToInt(inputY);
            } while(columnToInt(inputY) == -1);

            errorColumnCounter = 0;

            if(auxBoard[x][y].equals(" ")){
                System.out.printf("\n\tMovimento inválido. Insira um movimento válido...\n");
            }
        } while(auxBoard[x][y].equals(" "));

        choice[0] = x;
        choice[1] = y;

        return choice;
    };

    @Override
    public void move(Piece[][] board, int x, int y){
        board[x][y] = board[super.getPosX()][super.getPosY()];
        board[super.getPosX()][super.getPosY()] = new Empty(false, super.getPosX(), super.getPosY());
        super.setPosX(x);
        super.setPosY(y);
    };

    @Override
    public void moveOperation(Board boardInstance, Piece[][] board, String[][] auxBoard){
        int[] choice = new int[2];
        int possiblePlays = 0;
        possiblePlays = showValidMoves(board, auxBoard);
        if(possiblePlays > 0){
            boardInstance.displayBoardAndMoves();
            choice = getUserPlayChoice(board, auxBoard);
            move(board, choice[0], choice[1]);
        } else {
            boardInstance.displayBoardAndMoves();
            System.out.println("\n\tNão há movimentos possíveis para a peça...");
            sc.nextLine();
        }
        zerarMoves(auxBoard);
    };
}
