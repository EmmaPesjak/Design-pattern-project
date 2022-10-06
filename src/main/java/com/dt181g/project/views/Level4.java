package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level4 extends JPanel {

    MyButton myButton = new MyButton("Channel crystal");

    JLabel healthLabel = new JLabel();

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public Level4 (JLabel monsterImg, String name) {

        //observer och producer/consumer

        JLabel row1 = new JLabel("Hero! I am Vaelarya Vision Walker, the mighty dragon. Some monsters are attacking me!");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Grab that healing crystal and start channeling to heal me, quickly!");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);

        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
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

        //revalidateRepaint();
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
