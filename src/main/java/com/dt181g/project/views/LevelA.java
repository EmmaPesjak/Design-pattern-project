package com.dt181g.project.views;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

public class LevelA extends BaseLevel {

    public LevelA(BaseMonster monster, MyButton myButton) {

        JPanel topPanel = new JPanel();
        JLabel redLabel = new JLabel("HEJ");
        redLabel.setFont(Constants.TEXT_FONT);
        redLabel.setForeground(Constants.TEXT_COLOR);
        topPanel.add(redLabel);
        setTopPanel(topPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.add(monster.getMonsterImg());
        setCenterPanel(centerPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBottomPanel(bottomPanel);
    }

}
