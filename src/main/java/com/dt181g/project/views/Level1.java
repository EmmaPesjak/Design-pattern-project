package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level1 extends JPanel {

    MyButton myButton = new MyButton("NÄSTA");

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public Level1(JLabel monsterImg, String name) {

        JLabel redLabel = new JLabel(name);
        redLabel.setFont(Constants.TEXT_FONT);
        redLabel.setForeground(Constants.TEXT_COLOR);
        topPanel.add(redLabel);

        centerPanel.add(monsterImg);

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void addLvl1ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
    }

    public JPanel getTopPanel(){
        return topPanel;
    }

    public JPanel getCenterPanel(){
        return centerPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }
}
