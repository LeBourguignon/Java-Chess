package controllers;

import patterns.Subject;
import patterns.ViewType;

public class Controller extends Subject {
    private ViewType currentScreen = ViewType.NONE;

    public Controller() {

    }

    public ViewType getCurrentScreen() { return currentScreen; }
}
