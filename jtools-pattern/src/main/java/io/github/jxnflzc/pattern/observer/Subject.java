package io.github.jxnflzc.pattern.observer;

import java.util.Vector;

/**
 * @author jxnflzc
 * @version 1.0
 */
public abstract class Subject {
    /**
     * Observers of subject
     */
    private Vector<Observer> observers;

    public Subject() {
        observers = new Vector<>();
    }

    /**
     * Add observer to observers
     * @param observer New observer
     */
    public synchronized void addObserver(Observer observer) {
        if (null == observer) {
            throw new NullPointerException();
        } else {
            observers.add(observer);
        }
    }

    /**
     * Remove observer to observers
     * @param observer Observer to be removed
     */
    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notify observer without info
     */
    public void notifyObserver() {
        notifyObserver(null);
    }

    /**
     * Notify observer with info
     * @param arg Info
     */
    public void notifyObserver(Object arg) {
        for (Observer observer : observers) {
            observer.update(arg);
        }
    }

    /**
     * Clear all observers
     */
    public void clearObservers() {
        if (null == observers) {
            throw new NullPointerException();
        } else {
            observers.clear();
        }
    }
}
