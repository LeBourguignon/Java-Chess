package patterns;

import controllers.Controller;

import java.io.IOException;

public abstract class View extends Observer{
    protected Controller controller;
    protected ViewType viewType;

    public View(Controller _controller) {
        controller = _controller;
        controller.addObserver(this);
        viewType = ViewType.NONE;
    }

    protected boolean checkView() {
        return viewType == controller.getCurrentScreen();
    }

    public void toNotify() throws IOException {
        if (checkView())
            update();
    }

    protected abstract void update() throws IOException;
}
