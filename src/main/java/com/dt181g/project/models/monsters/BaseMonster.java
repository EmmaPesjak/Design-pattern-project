package com.dt181g.project.models.monsters;

import javax.swing.*;

/**
 * Abstract base class for all monsters in the game.
 * @author Emma Pesjak
 */
public abstract class BaseMonster {

    private String name;
    private ImageIcon monsterImg;

    /**
     * Getter for the monster's name.
     * @return the name of the monster.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the monster's name.
     * @param name is the name of the monster.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the monster's ImageIcon.
     * @return the ImageIcon of the monster.
     */
    public ImageIcon getMonsterImg() {
        return monsterImg;
    }

    /**
     * Setter for the monster's ImageIcon.
     * @param monsterImg is the ImageIcon of the monster.
     */
    public void setMonsterImg(ImageIcon monsterImg) {
        this.monsterImg = monsterImg;
    }
}
