package patterns;

import controllers.Controller;

import java.io.IOException;

public abstract class View extends Observer{
    protected Controller controller;
    protected ViewType viewType;

    public View(Controller controller) {
        this.controller = controller;
        this.controller.addObserver(this);
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
