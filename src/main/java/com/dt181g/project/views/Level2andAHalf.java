package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level2andAHalf extends BaseLevel {

    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    MyButton myButton = new MyButton("YOLO");
    ImageIcon monsterImg;
    String name;
    ActionListener listener;

    public Level2andAHalf (ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;

        bigPanel.setLayout(new BorderLayout());
    }

    public void updateLevel2andahalf(ImageIcon char1, ImageIcon char2, ImageIcon char3) {

        centerPanel.add(new JLabel(char1));
        centerPanel.add(new JLabel(char2));
        centerPanel.add(new JLabel(char3));
        centerPanel.revalidate();
        centerPanel.repaint();
    }


    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_BACKGROUND);
        topPanel.add(new JLabel(monsterImg));
        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. This is my abstract factory<br>" +
                "Want to create stuff? You can either get unicorns or monsters, totally random since my <br>" +
                "abstract factory is creating factories. </html>");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.add(label);

        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_BACKGROUND);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_BACKGROUND);
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
