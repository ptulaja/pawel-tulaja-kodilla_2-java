package com.kodilla.patterns2.Observer.forum;

public interface Observable {
    void registerObserver(Observer observer);
    void notifyObservers();
    void removeObserver(Observer observer);
}
