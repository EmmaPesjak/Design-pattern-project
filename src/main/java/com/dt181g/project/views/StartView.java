package com.dt181g.project.views;

import com.dt181g.project.monsters.BaseMonster;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StartView extends JFrame {

    // Till images, sen addar man dem til en panel
    ImageIcon icon = new ImageIcon("img/monsters/yellowMonster.png");
    JLabel picLabel = new JLabel(icon);
    ImageIcon icon2 = new ImageIcon("img/monsters/blueMonster.png");
    JLabel picLabel2 = new JLabel(icon2);
    ImageIcon icon3 = new ImageIcon("img/monsters/greenMonster.png");
    JLabel picLabel3 = new JLabel(icon3);
    ImageIcon icon4 = new ImageIcon("img/monsters/redMonster.png");
    JLabel picLabel4 = new JLabel(icon4);


    JButton infoButton = new JButton("Info");
    JButton startButton = new JButton("Start");

    JPanel titlePanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public StartView() {

        // General layout
        this.setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title panel
        titlePanel.setBorder(new EmptyBorder(80, 0, 0, 0));
        titlePanel.setBackground(Constants.COLOR_MIDNIGHT);
        JLabel title = new JLabel("Speltitel");
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.COLOR_TEXT);
        titlePanel.add(title);
        titlePanel.setPreferredSize(new Dimension(1000, 200));

        // Center panel
        centerPanel.setBorder(new EmptyBorder(40, 20, 20, 40));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(picLabel);
        centerPanel.add(picLabel2);
        centerPanel.add(picLabel4);
        centerPanel.add(picLabel3);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);

        // Bottom panel
        bottomPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(infoButton);
        bottomPanel.add(startButton);



        this.add(titlePanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
