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
    MyButton quitButton = new MyButton("Quit game");

    public PostLevel(ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
        bigPanel.setLayout(new BorderLayout());
    }

    public void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        JLabel completed = new JLabel("You completed the level! Well done!");
        completed.setFont(Constants.TITLE_FONT);
        completed.setForeground(Constants.TEXT_COLOR);
        topPanel.add(completed);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.add(Constants.IMAGE_STAR);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.add(quitButton);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
