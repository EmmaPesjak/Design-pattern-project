package com.dt181g.project.models.monsters;


import javax.swing.*;

//factory pattern
/**
 *
 * @author Emma Pesjak
 */
public abstract class BaseMonster {

    private String name;
    private ImageIcon monsterImg;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public ImageIcon getMonsterImg() {
        return monsterImg;
    }

    /**
     *
     * @param monsterImg
     */
    public void setMonsterImg(ImageIcon monsterImg) {
        this.monsterImg = monsterImg;
    }


    //lägg till grejor som monsterna gör??

}
