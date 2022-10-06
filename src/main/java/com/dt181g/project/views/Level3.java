package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level3 extends JPanel {

    MyButton myButton = new MyButton("Check answer");

    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");

    JTextField bucket1 = new JTextField(8);
    JTextField bucket2 = new JTextField(8);
    JTextField bucket3 = new JTextField(8);

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();


    public Level3(JLabel monsterImg, String name) {

        JLabel row1 = new JLabel("Hi, my name is " + name + " the Ugly Flesh Beast, long name I know. I lost my brother");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Rothead so now I'm sad. Can you cheer me up by solving my riddle?");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        JLabel row3 = new JLabel("What do you call a monster with a high IQ?");
        row3.setFont(Constants.TEXT_FONT);
        row3.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);
        topPanel.add(row3);

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

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public boolean rightAnswerFrank() {
        return radioButton2.isSelected();
    }

    public void addLvl3ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
    }

    public int getNumb1Yellow() {
        return Integer.parseInt(bucket1.getText());
    }

    public int getNumb2Yellow() {
        return Integer.parseInt(bucket2.getText());
    }

    public int getNumb3Yellow() {
        return Integer.parseInt(bucket3.getText());
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
