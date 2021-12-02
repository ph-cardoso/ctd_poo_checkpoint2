package pieces;

import java.util.Scanner;
import utils.ConsoleColors;
import board.Board;

public class Queen extends Piece {
    Scanner sc = new Scanner(System.in);

    public Queen(boolean isWhite, int posX, int posY) {
        super(isWhite, posX, posY);
    }

    @Override
    public String toString() {
        String content = "";
        if(super.isWhite()){
            content += ConsoleColors.WHITE_BOLD_BRIGHT;
            content += "Q";
            content += ConsoleColors.RESET;
            return content;
        } else {
            content += ConsoleColors.RED_BOLD_BRIGHT;
            content += "Q";
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
        int contador = 1;
        int possiblePlays = 0;

        // Atribuir a peça a casa em que ela se encontra no auxBoard
        auxBoard[super.getPosX()][super.getPosY()] = board[super.getPosX()][super.getPosY()].toString();

        int i = super.getPosX();
        int j = super.getPosY();

        if(super.isWhite()){
            // Diagonal Superior Direita
            while(i < 8 && j < 8) {
                if(i != 7 && j != 7) {
                    i++;
                    j++;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")) {
                    dir1++;
                } else {
                    if(!board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na diagonal Superior Direita
            while(dir1 > 0) {
                i++;
                j++;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir1--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal Superior Esquerda
            while(i < 8 && j > -1) {
                if(i != 7 && j != 0) {
                    i++;
                    j--;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir2++;
                } else {
                    if(!board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na diagonal Superior Esquerda
            while(dir2 > 0) {
                i++;
                j--;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir2--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal Inferior Direita
            while(i > -1 && j < 8) {
                if(i != 0 && j != 7) {
                    i--;
                    j++;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir3++;
                } else {
                    if(!board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na Diagonal Inferior Direita
            while(dir3 > 0) {
                i--;
                j++;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir3--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal inferior Esquerda
            while(i > -1 && j > -1)
            {
                if(i != 0 && j != 0) {
                    i--;
                    j--;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir4++;
                } else {
                    if(!board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na Diagonal Inferior Esquerda
            while(dir4 > 0)
            {
                i--;
                j--;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir4--;
            }

            // Norte
            for(i = super.getPosX() + 1; i < 8; i++) {
                if(board[i][super.getPosY()].toString().equals(" ")) {
                    dir5++;
                } else {
                    if(!board[i][super.getPosY()].isWhite()){
                        auxBoard[i][super.getPosY()] = board[i][super.getPosY()].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Norte
            for(i = 0; i < dir5; i++) {
                auxBoard[super.getPosX() + contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador

            // Sul
            for(i = super.getPosX() - 1; i > -1; i--) {
                if(board[i][super.getPosY()].toString().equals(" ")) {
                    dir6++;
                } else {
                    if(!board[i][super.getPosY()].isWhite()) {
                        auxBoard[i][super.getPosY()] = board[i][super.getPosY()].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Sul
            for(i = 0; i < dir6; i++) {
                auxBoard[super.getPosX() - contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador
            // Direita
            for(i = super.getPosY() + 1; i < 8; i++) {
                if(board[super.getPosX()][i].toString().equals(" ")) {
                    dir7++;
                } else {
                    if(!board[super.getPosX()][i].isWhite()){
                        auxBoard[super.getPosX()][i] = board[super.getPosX()][i].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Direita
            for(i = 0; i < dir7; i++) {
                auxBoard[super.getPosX()][super.getPosY() + contador] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador

            // Esquerda
            for(i = super.getPosY() - 1; i > -1; i--){
                if(board[super.getPosX()][i].toString().equals(" ")) {
                    dir8++;
                } else {
                    if(!board[super.getPosX()][i].isWhite()){
                        auxBoard[super.getPosX()][i] = board[super.getPosX()][i].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos possíveis
            for(i = 0; i < dir8; i++)
            {
                auxBoard[super.getPosX()][super.getPosY() - contador] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }
        } else {
            // Diagonal Superior Direita
            while(i < 8 && j < 8) {
                if(i != 7 && j != 7) {
                    i++;
                    j++;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")) {
                    dir1++;
                } else {
                    if(board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na diagonal Superior Direita
            while(dir1 > 0) {
                i++;
                j++;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir1--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal Superior Esquerda
            while(i < 8 && j > -1) {
                if(i != 7 && j != 0) {
                    i++;
                    j--;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir2++;
                } else {
                    if(board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na diagonal Superior Esquerda
            while(dir2 > 0) {
                i++;
                j--;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir2--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal Inferior Direita
            while(i > -1 && j < 8) {
                if(i != 0 && j != 7) {
                    i--;
                    j++;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir3++;
                } else {
                    if(board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na Diagonal Inferior Direita
            while(dir3 > 0) {
                i--;
                j++;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir3--;
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Diagonal inferior Esquerda
            while(i > -1 && j > -1)
            {
                if(i != 0 && j != 0) {
                    i--;
                    j--;
                } else {
                    break;
                }

                if(board[i][j].toString().equals(" ")){
                    dir4++;
                } else {
                    if(board[i][j].isWhite()){
                        auxBoard[i][j] = board[i][j].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Reseta o contador
            i = super.getPosX();
            j = super.getPosY();

            // Coloca o X na Diagonal Inferior Esquerda
            while(dir4 > 0)
            {
                i--;
                j--;
                auxBoard[i][j] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                dir4--;
            }

            // Norte
            for(i = super.getPosX() + 1; i < 8; i++) {
                if(board[i][super.getPosY()].toString().equals(" ")) {
                    dir5++;
                } else {
                    if(board[i][super.getPosY()].isWhite()){
                        auxBoard[i][super.getPosY()] = board[i][super.getPosY()].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Norte
            for(i = 0; i < dir5; i++) {
                auxBoard[super.getPosX() + contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador

            // Sul
            for(i = super.getPosX() - 1; i > -1; i--) {
                if(board[i][super.getPosY()].toString().equals(" ")) {
                    dir6++;
                } else {
                    if(board[i][super.getPosY()].isWhite()) {
                        auxBoard[i][super.getPosY()] = board[i][super.getPosY()].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Sul
            for(i = 0; i < dir6; i++) {
                auxBoard[super.getPosX() - contador][super.getPosY()] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador
            // Direita
            for(i = super.getPosY() + 1; i < 8; i++) {
                if(board[super.getPosX()][i].toString().equals(" ")) {
                    dir7++;
                } else {
                    if(board[super.getPosX()][i].isWhite()){
                        auxBoard[super.getPosX()][i] = board[super.getPosX()][i].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos Direita
            for(i = 0; i < dir7; i++) {
                auxBoard[super.getPosX()][super.getPosY() + contador] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }

            contador = 1; // Reseta o contador

            // Esquerda
            for(i = super.getPosY() - 1; i > -1; i--){
                if(board[super.getPosX()][i].toString().equals(" ")) {
                    dir8++;
                } else {
                    if(board[super.getPosX()][i].isWhite()){
                        auxBoard[super.getPosX()][i] = board[super.getPosX()][i].toString();
                        possiblePlays++;
                    }

                    break;
                }
            }

            // Coloca um X no Moves nos movimentos possíveis
            for(i = 0; i < dir8; i++)
            {
                auxBoard[super.getPosX()][super.getPosY() - contador] = (ConsoleColors.WHITE_BOLD_BRIGHT + "X" + ConsoleColors.RESET);
                possiblePlays++;
                contador++;
            }
        }

        return possiblePlays;
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
