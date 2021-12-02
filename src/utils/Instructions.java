package utils;

import java.util.Scanner;

public class Instructions {
    private static Scanner sc = new Scanner(System.in);

    private Instructions() {}

    public static void showInstructions() {
        ClearConsole.clearConsole();
        System.out.printf("\n\tBem vindo ao nosso jogo de Xadrez!\n");
        System.out.printf("\n\tAutores do Projeto:\n");
        System.out.printf("\n\tPedro Henrique Lima Cardoso");
        System.out.printf("\n\tWagner Sena\n");

        System.out.printf("\n\tCor das peças:\n");
        System.out.printf("\n\tBrancas: %sBranco%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tPretas: %sVermelho%s\n", ConsoleColors.RED_BOLD_BRIGHT, ConsoleColors.RESET);

        System.out.printf("\n\tMapeamento das peças:\n");
        System.out.printf("\n\tPeão: %sP%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tTorre: %sT%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tCavalo: %sC%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tBispo: %sB%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tRainha: %sQ%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\tRei: %sK%s", ConsoleColors.WHITE_BOLD_BRIGHT, ConsoleColors.RESET);
        System.out.printf("\n\n");
        System.out.printf("\tPressione ENTER para continuar...");

        sc.nextLine();
    }
}
