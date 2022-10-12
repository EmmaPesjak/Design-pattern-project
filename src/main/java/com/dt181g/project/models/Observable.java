package com.dt181g.project.models;

/**
 *
 * @author Emma Pesjak
 */
public interface Observable {

    /**
     *
     * @param observer
     */
    void addObserver(Observer observer);

    /**
     *
     */
    void notifyObservers();

}
