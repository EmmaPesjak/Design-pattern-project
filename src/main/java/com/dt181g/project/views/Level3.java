package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level3 extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    ImageIcon monsterImg;
    String name;
    MyButton myButton = new MyButton("Check answer");
    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");
    ActionListener listener;

    public Level3(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    public boolean rightAnswerFrank() {
        return radioButton2.isSelected();
    }

    @Override
    void addTopPanel() {
        JLabel label = new JLabel("<html>Hi, my name is " + name + " the Ugly Flesh Beast, long name I know.<br>I lost my brother" +
                " Rothead so now I'm sad.<br>Can you cheer me up by solving my riddle?<br>What do you call a monster with a high IQ? </html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        radioButton1.setBackground(Constants.COLOR_BACKGROUND);
        radioButton1.setForeground(Constants.COLOR_TEXT);
        radioButton1.setFont(Constants.FONT_TEXT);
        radioButton2.setBackground(Constants.COLOR_BACKGROUND);
        radioButton2.setForeground(Constants.COLOR_TEXT);
        radioButton2.setFont(Constants.FONT_TEXT);
        radioButton3.setBackground(Constants.COLOR_BACKGROUND);
        radioButton3.setForeground(Constants.COLOR_TEXT);
        radioButton3.setFont(Constants.FONT_TEXT);
        GridBagLayout gridBagLayout = new GridBagLayout();
        centerPanel.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(new JLabel(monsterImg), gbc);
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
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
