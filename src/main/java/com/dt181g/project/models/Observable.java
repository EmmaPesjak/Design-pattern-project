package com.dt181g.project.models;

import com.dt181g.project.controllers.Observer;

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
