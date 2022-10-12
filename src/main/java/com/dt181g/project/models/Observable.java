package com.dt181g.project.models;

import com.dt181g.project.controllers.Observer;

/**
 * Interface used by the observable (Vaelarya) to add and notify observers.
 * @author Emma Pesjak
 */
public interface Observable {

    /**
     * Method to add observers.
     * @param observer is the observer.
     */
    void addObserver(Observer observer);

    /**
     * Method to notify observers.
     */
    void notifyObservers();

}
