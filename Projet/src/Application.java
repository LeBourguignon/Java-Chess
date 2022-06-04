import models.Board;
import view.Game;

public class Application {
    public static void main(String arg[]) {
        Game game = new Game(new Board());
        game.start();
    }
}
