package game;

import java.util.Scanner;
import pieces.*;
import utils.ClearConsole;
import board.Board;

public class Game {
    private static Game gameInstance;
    private Scanner sc = new Scanner(System.in);
    private Board boardInstace = Board.getInstance();
    private Piece[][] board = boardInstace.getBoard();
    private String[][] auxBoard  = boardInstace.getAuxBoard();

    private int turnCounter = 0;
    private boolean isWhiteTurn = true;
    private String winner = "";

    private int pieceX = 0;
    private int pieceY = 0;
    private char pieceInputY = ' ';
    private int errorColumnCounter = 0; // Auxiliar de gambiarra para driblar o buffer

    private Game() {}

    public static Game getInstance() {
        if (gameInstance == null) {
            gameInstance = new Game();
        }
        return gameInstance;
    }

    private void showGameStats(){
        System.out.printf("\n\tQtd de Turnos: %d\n", turnCounter);
        System.out.printf("\tVez de jogar: %s\n\n", isWhiteTurn ? "\033[1;97mPeças Brancas\033[0m" : "\033[1;91mPeças Pretas\033[0m");
    }

    private void getUserPieceChoice(){
        do{
            System.out.printf("\n\tSelecione a peça que deseja mover: ");

            // Input da linha
            do {
                System.out.printf("\n\tNúmero Linha: ");
                pieceX = sc.nextInt() - 1;

                if(pieceX < 0 || pieceX > 7){
                    System.out.printf("\n\tLinha inválida, tente novamente...");
                }
            } while(pieceX < 0 || pieceX > 7);

            // Input da coluna
            do {
                System.out.printf("\tLetra Coluna: ");

                if(errorColumnCounter == 0){
                    sc.nextLine(); // Clear input buffer
                }

                pieceInputY = sc.nextLine().toUpperCase().charAt(0);

                if(Piece.columnToInt(pieceInputY) == -1){
                    System.out.printf("\n\tColuna inválida, tente novamente...\n");
                    errorColumnCounter++;
                }

                pieceY = Piece.columnToInt(pieceInputY);
            } while(Piece.columnToInt(pieceInputY) == -1);

            errorColumnCounter = 0;

            if((board[pieceX][pieceY].isWhite() && !isWhiteTurn) || (!board[pieceX][pieceY].isWhite() && isWhiteTurn)){
                System.out.printf("\n\tSeleção de peça não condiz com jogador do turno...\n");
            }
        } while((board[pieceX][pieceY].isWhite() && !isWhiteTurn) || (!board[pieceX][pieceY].isWhite() && isWhiteTurn));
    }

    private boolean checkWinner(){
        int counter = 0;

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j].getClass().getSimpleName().equals("King")){
                    counter++;
                }
            }
        }

        if(counter != 2){
            return true;
        } else {
            return false;
        }
    }

    public void startGame() {
        while(!this.checkWinner()){
            ClearConsole.clearConsole();
            this.showGameStats();
            boardInstace.displayBoard();
            this.getUserPieceChoice();
            ClearConsole.clearConsole();
            board[pieceX][pieceY].moveOperation(boardInstace, board, auxBoard);
            if(this.checkWinner()){
                winner = isWhiteTurn ? "Brancas" : "Pretas";
                break;
            }

            // Troca de turno
            if(isWhiteTurn){
                isWhiteTurn = false;
            } else {
                isWhiteTurn = true;
            }

            turnCounter++;
        }

        ClearConsole.clearConsole();
        System.out.printf("\nAs peças %s ganharam!!!\n", winner);
        System.out.printf("\nO jogo durou %d turnos\n\n", turnCounter);
        sc.nextLine();
    }

}