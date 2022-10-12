package com.dt181g.project.models;

/**
 * Abstract factory interface used to produce factories in the game.
 * @author Emma Pesjak
 */
public interface CharacterFactory<T> {

    /**
     * Method for creating a random character in the game.
     * @return a character from a factory.
     */
    T createChar();

}
