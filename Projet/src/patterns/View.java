package patterns;

import controllers.Controller;

public abstract class View extends Observer{
    private Controller controller;
    private ViewType viewType;

    public View(Controller _controller) {
        controller = _controller;
    }

    private boolean checkView() {
        return viewType == controller.getCurrentScreen();
    }

    public void toNotify() {
        if (checkView())
            update();
    }

    public abstract void update();
}
