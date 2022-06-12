package patterns;

import java.io.IOException;

public abstract class Observer {
    public Observer() {

    }

    public abstract void toNotify() throws IOException;
}
