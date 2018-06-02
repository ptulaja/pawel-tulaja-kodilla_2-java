package com.kodilla.patterns2.Observer.Homework;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
