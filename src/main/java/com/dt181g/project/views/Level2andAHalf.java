package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level2andAHalf extends BaseLevel {

    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    MyButton myButton = new MyButton("YOLO");
    JLabel monsterImg;
    String name;
    ActionListener listener;

    public Level2andAHalf (ViewFrame viewFrame, JLabel monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;

        bigPanel.setLayout(new BorderLayout());
    }

    public void updateLevel2andahalf(JLabel char1, JLabel char2, JLabel char3) {
        centerPanel.add(char1);
        centerPanel.add(char2);
        centerPanel.add(char3);
        bottomPanel.add(Constants.IMAGE_ANGRYCORN);
        revalidate();
        repaint();
    }


    @Override
    void addTopPanel() {
        topPanel.add(monsterImg);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.add(Constants.IMAGE_GLAMCORN);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);

    }

    @Override
    void addButtonListener() {
        myButton.addActionListener(listener);
    }

    @Override
    void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
