package controllers;

import patterns.Subject;
import patterns.ViewType;

import javax.swing.*;
import java.awt.*;

public class Controller extends Subject {
    private ViewType currentScreen = ViewType.GAME;

    public JFrame frame;

    public Controller() {
        frame = new JFrame("Java Chess");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public ViewType getCurrentScreen() { return currentScreen; }
}
