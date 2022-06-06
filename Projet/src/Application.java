import models.Board;
import view.Game;

import java.io.IOException;

public class Application {
    public static void main(String arg[]) throws IOException {
        Game game = new Game(new Board());
        game.start();
    }
}
