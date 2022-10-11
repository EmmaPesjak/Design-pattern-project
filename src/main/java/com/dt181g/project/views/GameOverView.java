package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverView extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Restart level 5");
    ActionListener listener;

    public GameOverView(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }


    @Override
    void addTopPanel() {
        JLabel gameOver = new JLabel("Game Over!");
        gameOver.setFont(Constants.FONT_BIG);
        gameOver.setForeground(Constants.COLOR_TEXT);
        topPanel.add(gameOver);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setBorder(new EmptyBorder(120, 5, 5,5));
        centerPanel.add(new JLabel(Constants.IMAGE_STAR));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
