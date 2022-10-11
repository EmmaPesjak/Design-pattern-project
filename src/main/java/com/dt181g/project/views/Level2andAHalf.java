package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level2andAHalf extends BaseLevel {

    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton nextLevelBtn = new MyButton("Next level");
    MyButton produceBtn = new MyButton("Produce!");
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
        topPanel.add(new JLabel(monsterImg));
        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. <br>This is my abstract factory. " +
                "It creates factories <br>which can create unicorns or monsters. " +
                "Want to create<br> some totally random characters? </html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(new JLabel(Constants.IMAGE_FACTORY));
        topPanel.add(label);

        bigPanel.add(topPanel, BorderLayout.NORTH);




    }

    @Override
    void addCenterPanel() {
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(produceBtn);
        bottomPanel.add(nextLevelBtn);

    }

    @Override
    void addButtonListener() {
        nextLevelBtn.addActionListener(listener);
    }

    @Override
    void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
