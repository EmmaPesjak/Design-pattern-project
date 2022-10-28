package com.dt181g.project.models.factories;

/**
 * Abstract factory interface used to produce factories in the game.
 * @author Emma Pesjak
 */
public interface AbstractFactory {

    /**
     * Method for creating a random character in the game.
     * @return a character from a factory.
     */
    BaseCharacter createChar();

    /**
     * Method for creating a random color to use in the game's GUI.
     * @return a color from a factory.
     */
    BaseColor createColor();
}
