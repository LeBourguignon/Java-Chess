package patterns;

import java.io.IOException;
import java.util.Vector;

public class Subject {
    protected Vector<Observer> observers;

    public Subject() {
        observers = new Vector<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void toNotify() throws IOException {
        for (Observer observer: observers) {
            observer.toNotify();
        }
    }
}
