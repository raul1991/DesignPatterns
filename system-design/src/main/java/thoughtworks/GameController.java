package thoughtworks;

/**
 * This class should govern the rules of the game and manages the turns of the player
 */
public class GameController {
    private boolean isGameOver;
    private Board board;

    public GameController(Board board) {
        this.board = board;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
