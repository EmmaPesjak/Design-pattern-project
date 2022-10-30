package com.dt181g.project.factories;

public abstract class BaseCharacter {

    private String name;
    private String img;

    /**
     * Getter for the character's name.
     * @return the name of the character.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the character's name.
     * @param name is the name of the character.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the character's file path string.
     * @return the string file path of the character.
     */
    public String getImg() {
        return img;
    }

    /**
     * Setter for the character's file path string.
     * @param img is the string file path of the character.
     */
    public void setImg(String img) {
        this.img = img;
    }
}
