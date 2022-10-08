package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PreLevel extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    MyButton infoButton = new MyButton("Info");
    MyButton startButton = new MyButton("Start");

    public PreLevel(ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
        bigPanel.setLayout(new BorderLayout());
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TEXT_COLOR);
        topPanel.add(title);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_YELLOW_MONSTER);
        centerPanel.add(Constants.IMAGE_BLUE_MONSTER);
        centerPanel.add(Constants.IMAGE_RED_MONSTER);
        centerPanel.add(Constants.IMAGE_GREEN_MONSTER);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(infoButton);
        bottomPanel.add(startButton);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    @Override
    public void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }

}
