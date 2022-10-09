package com.dt181g.project.models.monsters;


import javax.swing.*;

//factory pattern
public abstract class BaseMonster {

    private String name;
    private JLabel monsterImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JLabel getMonsterImg() {
        return monsterImg;
    }

    public void setMonsterImg(JLabel monsterImg) {
        this.monsterImg = monsterImg;
    }


    //lägg till grejor som monsterna gör??

}
