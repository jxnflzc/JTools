package io.github.jxnflzc.pattern.observer;

import java.util.Vector;

public abstract class Subject {
    private Vector<Observer> observers;

    public Subject() {
        observers = new Vector<>();
    }

    public synchronized void addObserver(Observer observer) {
        if (null == observer) {
            throw new NullPointerException();
        } else {
            observers.add(observer);
        }
    }

    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        notifyObserver(null);
    }

    public void notifyObserver(Object arg) {
        for (Observer observer : observers) {
            observer.update(arg);
        }
    }

    public void clearObservers() {
        if (null == observers) {
            throw new NullPointerException();
        } else {
            observers.clear();
        }
    }
}
