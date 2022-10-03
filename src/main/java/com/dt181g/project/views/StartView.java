package com.dt181g.project.views;

import javax.swing.*;
import java.awt.*;

public class StartView extends JFrame {

    ImageIcon icon = new ImageIcon("img/monster.png");

    JLabel picLabel = new JLabel(icon);

    public StartView() {

        this.setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel calcPanel = new JPanel();
        calcPanel.add(picLabel);
        this.add(calcPanel);

        calcPanel.setBackground(Color.black);

    }
}
