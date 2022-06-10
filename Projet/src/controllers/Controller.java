package controllers;

import patterns.Subject;
import patterns.ViewType;

import javax.swing.*;

public class Controller extends Subject {
    private ViewType currentScreen = ViewType.GAME;

    public JFrame frame;

    public Controller() {
        frame = new JFrame("Java Chess");
    }

    public ViewType getCurrentScreen() { return currentScreen; }
}
