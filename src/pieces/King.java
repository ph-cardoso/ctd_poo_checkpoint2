package pieces;

import java.util.Scanner;
import utils.ConsoleColors;
import board.Board;

public class King extends Piece {

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
        auxMoves[linha1][coluna1] = whiteKing;
			if(tabuleiro[linha1 - 1][coluna1] == ' ') //Superior
				key1++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 - 1][coluna1] == black[i])
					{
						auxMoves[linha1 - 1][coluna1] = black[i];
						break;
					}
				}
			}
			if(key1 != 0)
				auxMoves[linha1 - 1][coluna1] = 'X';

			if(tabuleiro[linha1 - 1][coluna1 + 1] == ' ') //Diagonal superior direita
				key2++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 - 1][coluna1 + 1] == black[i])
					{
						auxMoves[linha1 - 1][coluna1 + 1] = black[i];
						break;
					}
				}
			}
			if(key2 != 0)
				auxMoves[linha1 - 1][coluna1 + 1] = 'X';

			if(tabuleiro[linha1 - 1][coluna1 - 1] == ' ') //Diagonal superior esquerda
				key3++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 - 1][coluna1 - 1] == black[i])
					{
						auxMoves[linha1 - 1][coluna1 - 1] = black[i];
						break;
					}
				}
			}
			if(key3 != 0)
				auxMoves[linha1 - 1][coluna1 - 1] = 'X';

			if(tabuleiro[linha1][coluna1 + 1] == ' ') //Direita
				key4++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1][coluna1 + 1] == black[i])
					{
						auxMoves[linha1][coluna1 + 1] = black[i];
						break;
					}
				}
			}
			if(key4 != 0)
				auxMoves[linha1][coluna1 + 1] = 'X';

			if(tabuleiro[linha1][coluna1 - 1] == ' ') //Esquerda
				key5++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1][coluna1 - 1] == black[i])
					{
						auxMoves[linha1][coluna1 - 1] = black[i];
						break;
					}
				}
			}
			if(key5 != 0)
				auxMoves[linha1][coluna1 - 1] = 'X';

			if(tabuleiro[linha1 + 1][coluna1 - 1] == ' ') //Diagonal Inferior esquerda
				key6++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 + 1][coluna1 - 1] == black[i])
					{
						auxMoves[linha1 + 1][coluna1 - 1] = black[i];
						break;
					}
				}
			}
			if(key6 != 0)
				auxMoves[linha1 + 1][coluna1 - 1] = 'X';

			if(tabuleiro[linha1 + 1][coluna1 + 1] == ' ') //Diagonal inferior direita
				key7++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 + 1][coluna1 + 1] == black[i])
					{
						auxMoves[linha1 + 1][coluna1 + 1] = black[i];
						break;
					}
				}
			}
			if(key7 != 0)
				auxMoves[linha1 + 1][coluna1 + 1] = 'X';

			if(tabuleiro[linha1 + 1][coluna1] == ' ') //Inferior
				key8++;
			else
			{
				for(i = 0; i < 6; i++)
				{
					if(tabuleiro[linha1 + 1][coluna1] == black[i])
					{
						auxMoves[linha1 + 1][coluna1] = black[i];
						break;
					}
				}
			}
			if(key8 != 0)
				auxMoves[linha1 + 1][coluna1] = 'X';
    };

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
