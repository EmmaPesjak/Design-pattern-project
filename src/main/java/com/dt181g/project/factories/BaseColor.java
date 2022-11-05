package com.dt181g.project.factories;

import java.awt.*;

/**
 * Abstract base class of the colors in the game used for the different character backgrounds in level 3.
 * @author Emma Pesjak
 */
public abstract class BaseColor {

    private Color color;

    /**
     * Getter for the color.
     * @return the color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter for the color.
     * @param color is the color.
     */
    public void setColor(Color color) {
        this.color = color;
    }
}
