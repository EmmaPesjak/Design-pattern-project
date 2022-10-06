package com.dt181g.project.views;

import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelC extends BaseLevel {

    //MyButton greenButton = new MyButton("Check answer");
    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");


    public LevelC(BaseMonster monster, MyButton myButton) {

        JPanel topPanel = new JPanel();
        JLabel row1 = new JLabel("Hi, my name is Partygut the Ugly Flesh Beast, long name I know. I lost my brother");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Rothead so now I'm sad. Can you cheer me up by solving my riddle?");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        JLabel row3 = new JLabel("What do you call a monster with a high IQ?");
        row3.setFont(Constants.TEXT_FONT);
        row3.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);
        topPanel.add(row3);
        setTopPanel(topPanel);

        JPanel centerPanel = new JPanel();
        radioButton1.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton1.setForeground(Constants.TEXT_COLOR);
        radioButton1.setFont(Constants.TEXT_FONT);
        radioButton2.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton2.setForeground(Constants.TEXT_COLOR);
        radioButton2.setFont(Constants.TEXT_FONT);
        radioButton3.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton3.setForeground(Constants.TEXT_COLOR);
        radioButton3.setFont(Constants.TEXT_FONT);
        GridBagLayout gridBagLayout = new GridBagLayout();
        centerPanel.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(monster.getMonsterImg(), gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(radioButton1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(radioButton2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(radioButton3, gbc);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        setCenterPanel(centerPanel);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBottomPanel(bottomPanel);
    }

    public boolean rightAnswerFrank() {
        return radioButton2.isSelected();
    }


   // public void addGreenButtonListener(ActionListener listener) {
      //  greenButton.addActionListener(listener);
   // }
}
