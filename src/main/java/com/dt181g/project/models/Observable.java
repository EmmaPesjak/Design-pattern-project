package com.dt181g.project.models;

public interface Observable {

    void addObserver(Observer observer);

    void notifyObservers();

}
