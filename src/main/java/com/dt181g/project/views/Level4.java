package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level4 extends JPanel {

    MyButton myButton = new MyButton("Channel crystal");

    JLabel healthLabel = new JLabel();

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public Level4 (JLabel monsterImg, String name) {


        topPanel.setPreferredSize(new Dimension(1000, 160));
        centerPanel.setPreferredSize(new Dimension(1000, 460));
        bottomPanel.setPreferredSize(new Dimension(1000, 80));
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);


        //observer och producer/consumer

        JLabel label = new JLabel("<html>Hero! I am Vaelarya Vision Walker, the mighty dragon. A monster " +
                "named " + name + " and his <br> " +
                "friends are attacking me! Grab that healing crystal and start channeling to heal me, quickly!</html>");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.add(label);

        //centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));

        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_DRAGON);
        centerPanel.add(monsterImg);
        centerPanel.add(Constants.IMAGE_CRYSTAL);


        //lägg till fler monsterbilder här

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
