package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FirstPage extends JPanel {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    MyButton infoButton = new MyButton("Info");
    MyButton startButton = new MyButton("Start");

    public FirstPage() {
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);

        // Top panel
        //topPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TEXT_COLOR);
        topPanel.add(title);

        // Center panel
        //centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_YELLOW_MONSTER);
        centerPanel.add(Constants.IMAGE_BLUE_MONSTER);
        centerPanel.add(Constants.IMAGE_RED_MONSTER);
        centerPanel.add(Constants.IMAGE_GREEN_MONSTER);

        // Bottom panel
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(infoButton);
        bottomPanel.add(startButton);

        //this.add(topPanel, BorderLayout.NORTH);
        //this.add(centerPanel, BorderLayout.CENTER);
        //this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
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
