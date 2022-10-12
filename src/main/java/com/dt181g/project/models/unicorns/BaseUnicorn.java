package com.dt181g.project.models.unicorns;

import javax.swing.*;

/**
 * Abstract base class for all unicorns in the game.
 * @author Emma Pesjak
 */
public abstract class BaseUnicorn {

    private ImageIcon unicornImg;

    /**
     * Getter for the unicorn's ImageIcon.
     * @return the ImageIcon of the unicorn.
     */
    public ImageIcon getUnicornImg() {
        return unicornImg;
    }

    /**
     * Setter for the unicorn's ImageIcon.
     * @param unicornImg is the ImageIcon of the unicorn.
     */
    public void setUnicornImg(ImageIcon unicornImg) {
        this.unicornImg = unicornImg;
    }
}
