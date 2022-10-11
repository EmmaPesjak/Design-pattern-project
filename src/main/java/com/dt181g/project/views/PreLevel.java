package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PreLevel extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Start");
    ActionListener listener;

    public PreLevel(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    @Override
    void addTopPanel() {
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.FONT_BIG);
        title.setForeground(Constants.COLOR_TEXT);
        topPanel.add(title);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(new JLabel(Constants.IMAGE_YELLOW_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_BLUE_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_RED_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_GREEN_MONSTER));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.add(myButton);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    void addButtonListener() {
        myButton.addActionListener(listener);
    }

    @Override
    public void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }

}
