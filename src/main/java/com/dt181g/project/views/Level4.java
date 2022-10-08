package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level4 extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel healthLabel = new JLabel();
    JLabel monsterImg;
    String name;
    MyButton myButton = new MyButton("Channel crystal");

    public Level4 (ViewFrame viewFrame, JLabel monsterImg, String name) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        bigPanel.setLayout(new BorderLayout());
    }

    public void updateLevel4(HealthPoolPanel healthPoolPanel, int health) {
        // skriva ut monsternas skada?
        bottomPanel.removeAll();
        healthLabel.setText("Vaelarya's health: " + health);
        healthLabel.setFont(Constants.TITLE_FONT);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setForeground(Constants.TEXT_COLOR);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(healthLabel);
        bottomPanel.add(healthPoolPanel);
        bottomPanel.revalidate();
        bottomPanel.repaint();
    }

    public void addLvl4ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        JLabel label = new JLabel("<html>Hero! I am Vaelarya Vision Walker, the mighty dragon. A monster " +
                "named " + name + " and his <br> " +
                "friends are attacking me! Grab that healing crystal and start channeling to heal me, quickly!</html>");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        //fixa större bild på vaelarya
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_DRAGON);
        centerPanel.add(monsterImg);
        centerPanel.add(Constants.IMAGE_CRYSTAL);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setPreferredSize(new Dimension(1000, 120));
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }

}
