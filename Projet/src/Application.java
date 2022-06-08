import models.Board;
import views.Game;

import java.io.IOException;

public class Application {
    public static void main(String arg[]) throws IOException {
        Game game = new Game(new Board());
        game.start();
    }
}
