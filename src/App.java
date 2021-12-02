import utils.Instructions;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = Game.getInstance();

        // Show instructions
        Instructions.showInstructions();

        // Call game runtime class
        game.startGame();
    }
}