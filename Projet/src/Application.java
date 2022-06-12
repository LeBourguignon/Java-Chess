import controllers.Controller;
import views.Game;

import java.io.IOException;

public class Application {
    public static void main(String[] arg) throws IOException {
        Controller controller = new Controller();
        Game game = new Game(controller);

        controller.toNotify();
    }
}
