package com.dt181g.project;

public interface Observable {

    void addObserver(Observer observer);

    void notifyObservers();

}
