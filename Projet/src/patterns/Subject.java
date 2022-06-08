package patterns;

import java.util.Vector;

public class Subject {
    private Vector<Observer> observers;

    public Subject() {

    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void toNotify() {
        for (Observer observer: observers) {
            observer.toNotify();
        }
    }
}
