package com.dt181g.project.models;

/**
 * Abstract factory
 * @author Emma Pesjak
 */
public interface CharacterFactory<T> {

    /**
     *
     * @return
     */
    T createChar();

}
