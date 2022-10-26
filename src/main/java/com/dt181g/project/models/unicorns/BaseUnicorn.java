package com.dt181g.project.models.unicorns;

/**
 * Abstract base class for all unicorns in the game.
 * @author Emma Pesjak
 */
public abstract class BaseUnicorn {

    private String unicornImg;

    /**
     * Getter for the unicorn's ImageIcon.
     * @return the ImageIcon of the unicorn.
     */
    public String getUnicornImg() {
        return unicornImg;
    }

    /**
     * Setter for the unicorn's ImageIcon.
     * @param unicornImg is the ImageIcon of the unicorn.
     */
    public void setUnicornImg(String unicornImg) {
        this.unicornImg = unicornImg;
    }
}
