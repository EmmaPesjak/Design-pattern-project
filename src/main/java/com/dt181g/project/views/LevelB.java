package com.dt181g.project.views;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LevelB extends BaseLevel {

    JPanel bottomPanel = new JPanel();
    JLabel healthLabel = new JLabel();

    public LevelB(BaseMonster monster, MyButton myButton) {

        //observer och producer/consumer

        JPanel topPanel = new JPanel();
        JLabel row1 = new JLabel("Hero! I am Vaelarya Vision Walker, the mighty dragon. Some monsters are attacking me!");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Grab that healing crystal and start channeling to heal me, quickly!");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);
        setTopPanel(topPanel);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_DRAGON);
        centerPanel.add(monster.getMonsterImg());
        centerPanel.add(Constants.IMAGE_CRYSTAL);
        setCenterPanel(centerPanel);


        //lägg till fler monsterbilder här

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBottomPanel(bottomPanel);
    }

    public void updateLevelB(HealthPoolPanel healthPoolPanel, int health) {

        // skriva ut monsternas skada?

        bottomPanel.removeAll();
        healthLabel.setText("Vaelarya's health: " + health);
        healthLabel.setFont(Constants.TITLE_FONT);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setForeground(Constants.TEXT_COLOR);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(healthLabel);
        bottomPanel.add(healthPoolPanel);

        //revalidateRepaint();
    }

}
