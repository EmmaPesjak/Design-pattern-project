package com.dt181g.project.views;

import javax.swing.*;

public class StartPanel extends JPanel {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

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
