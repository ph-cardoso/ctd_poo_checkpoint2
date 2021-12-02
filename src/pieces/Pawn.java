package pieces;

import java.util.Scanner;
import utils.ConsoleColors;
import board.Board;

public class Pawn extends Piece{
    Scanner sc = new Scanner(System.in);

    public Pawn(boolean isWhite, int posX, int posY) {
        super(isWhite, posX, posY);
    }

    @Override
    public String toString() {
        String content = "";
        if(super.isWhite()){
            content += ConsoleColors.WHITE_BOLD_BRIGHT;
            content += "P";
            content += ConsoleColors.RESET;
            return content;
        } else {
            content += ConsoleColors.RED_BOLD_BRIGHT;
            content += "P";
            content += ConsoleColors.RESET;
            return content;
        }
    }

    @Override
    public int showValidMoves(Piece[][] board, String[][] auxBoard){
        int dir1 = 0;
        int contador = 1;
        int possiblePlays = 0;

        // Atribuir a peça a casa em que ela se encontra no auxBoard
        auxBoard[super.getPosX()][super.getPosY()] = this.toString();

        if(super.isWhite()){
            //Caso o peão se encontre na posição inicial e possa andar 2 casas
            if(super.getPosX() == 1) {
                // Determina até onde é possível mover
                if(board[super.getPosX() + 1][super.getPosY()].toString().equals(" ")){
                    dir1++;
                }
                if(board[super.getPosX() + 2][super.getPosY()].toString().equals(" ")){
                    dir1++;
                }

                //Coloca um 'X' no auxBoard nos movimentos possíveis
                for(int i = 0; i < dir1; i++) {
                    auxBoard[super.getPosX() + contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                    contador++;
                    possiblePlays++;
                }
            } else {
                // Determina até onde é possível mover
                if(super.getPosX() != 7){
                    if(board[super.getPosX() + 1][super.getPosY()].toString().equals(" ")){
                        dir1++;
                    }
                }

                if(dir1 != 0){
                    auxBoard[super.getPosX() + 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                    possiblePlays++;
                }
            }

            // Possibilidade de ataque Direita
            if(super.getPosX() != 7 && super.getPosY() != 7){
                if(!board[super.getPosX() + 1][super.getPosY() + 1].isWhite()) {
                    auxBoard[super.getPosX() + 1][super.getPosY() + 1] = board[super.getPosX() + 1][super.getPosY() + 1].toString();
                    possiblePlays++;
                }
            }

            // Possibilidade de ataque Esquerda
            if(super.getPosX() != 7 && super.getPosY() != 0){
                if(!board[super.getPosX() + 1][super.getPosY() - 1].isWhite()) {
                    auxBoard[super.getPosX() + 1][super.getPosY() - 1] = board[super.getPosX() + 1][super.getPosY() - 1].toString();
                    possiblePlays++;
                }
            }
        } else {
             //Caso o peão se encontre na posição inicial e possa andar 2 casas
            if(super.getPosX() == 6) {
                // Determina até onde é possível mover
                if(board[super.getPosX() - 1][super.getPosY()].toString().equals(" ")){
                    dir1++;
                }
                if(board[super.getPosX() - 2][super.getPosY()].toString().equals(" ")){
                    dir1++;
                }

                //Coloca um 'X' no auxBoard nos movimentos possíveis
                for(int i = 0; i < dir1; i++) {
                    auxBoard[super.getPosX() - contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                    possiblePlays++;
                    contador++;
                }
            } else {
                // Determina até onde é possível mover4
                if(super.getPosX() != 0){
                    if(board[super.getPosX() - 1][super.getPosY()].toString().equals(" ")){
                        dir1++;
                    }
                }

                if(dir1 != 0){
                    auxBoard[super.getPosX() - 1][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                    possiblePlays++;
                }
            }

            // Possibilidade de ataque Esquerda
            if(super.getPosX() != 0 && super.getPosY() != 0){
                if(board[super.getPosX() - 1][super.getPosY() - 1].isWhite()) {
                    auxBoard[super.getPosX() - 1][super.getPosY() - 1] = board[super.getPosX() - 1][super.getPosY() - 1].toString();
                    possiblePlays++;
                }
            }

            // Possibilidade de ataque Direita
            if(super.getPosX() != 0 && super.getPosY() != 7){
                if(board[super.getPosX() - 1][super.getPosY() + 1].isWhite()) {
                    auxBoard[super.getPosX() - 1][super.getPosY() + 1] = board[super.getPosX() - 1][super.getPosY() + 1].toString();
                    possiblePlays++;
                }
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
    }

    @Override
    public void move(Piece[][] board, int x, int y){
        board[x][y] = board[super.getPosX()][super.getPosY()];
        board[super.getPosX()][super.getPosY()] = new Empty(false, super.getPosX(), super.getPosY());
        super.setPosX(x);
        super.setPosY(y);
    }

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
    }
}
