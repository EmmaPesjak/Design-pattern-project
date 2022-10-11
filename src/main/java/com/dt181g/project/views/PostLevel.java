package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PostLevel extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    MyButton myButton = new MyButton("Quit game");
    ActionListener listener;

    public PostLevel(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_BACKGROUND);
        JLabel completed = new JLabel("You completed the game! Well done!");
        completed.setFont(Constants.FONT_BIG);
        completed.setForeground(Constants.COLOR_TEXT);
        topPanel.add(completed);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_BACKGROUND);
        centerPanel.add(new JLabel(Constants.IMAGE_STAR));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_BACKGROUND);
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

    @Override
    void addButtonListener() {
        myButton.addActionListener(listener);
    }
}
