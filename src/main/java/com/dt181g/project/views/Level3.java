package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level3 extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JLabel monsterImg;
    String name;
    MyButton myButton = new MyButton("Check answer");
    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");

    public Level3(ViewFrame viewFrame, JLabel monsterImg, String name) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        bigPanel.setLayout(new BorderLayout());
    }

    public boolean rightAnswerFrank() {
        return radioButton2.isSelected();
    }

    public void addLvl3ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        JLabel label = new JLabel("<html>Hi, my name is " + name + " the Ugly Flesh Beast, long name I know. I lost my brother<br>" +
                "Rothead so now I'm sad. Can you cheer me up by solving my riddle? What do you call a monster <br>with a high IQ? </html>");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton1.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton1.setForeground(Constants.TEXT_COLOR);
        radioButton1.setFont(Constants.TEXT_FONT);
        radioButton2.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton2.setForeground(Constants.TEXT_COLOR);
        radioButton2.setFont(Constants.TEXT_FONT);
        radioButton3.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton3.setForeground(Constants.TEXT_COLOR);
        radioButton3.setFont(Constants.TEXT_FONT);
        GridBagLayout gridBagLayout = new GridBagLayout();
        centerPanel.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(monsterImg, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(radioButton1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(radioButton2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(radioButton3, gbc);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
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
}
