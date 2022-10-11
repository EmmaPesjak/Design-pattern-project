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

    public void updateLevel2andahalf(ImageIcon char1, ImageIcon char2, ImageIcon char3, ImageIcon char4, ImageIcon char5) {

        centerPanel.add(new JLabel(char1));
        centerPanel.add(new JLabel(char2));
        centerPanel.add(new JLabel(char3));
        centerPanel.add(new JLabel(char4));
        centerPanel.add(new JLabel(char5));

        centerPanel.revalidate();
        centerPanel.repaint();
    }


    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_BACKGROUND);
        topPanel.add(new JLabel(monsterImg));
        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. This is my abstract factory<br>" +
                "It creates factories which can create unicorns or monsters.<br>" +
                "Want to create some totally random characters? </html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(new JLabel(Constants.IMAGE_FACTORY));
        topPanel.add(label);

        bigPanel.add(topPanel, BorderLayout.NORTH);



        //bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
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
        bottomPanel.add(myButton);

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
