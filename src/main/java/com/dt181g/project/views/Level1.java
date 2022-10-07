package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Objects;

public class Level1 extends JPanel {

    MyButton myButton = new MyButton("NÄSTA");

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    String[] sortFunctions = new String[] {"All words", "Sort alphabetically.", "Count words longer than 5 letters."};
    JComboBox<String> comboBox = new JComboBox<>(sortFunctions);

    public Level1(JLabel monsterImg, String name) {

        topPanel.setPreferredSize(new Dimension(1000, 160));
        centerPanel.setPreferredSize(new Dimension(1000, 460));
        bottomPanel.setPreferredSize(new Dimension(1000, 80));
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);


        JLabel row1 = new JLabel("Hi, I'm " + name + ". I like words. These are my words. Want to play with them?");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(row1);



        centerPanel.add(comboBox);
        centerPanel.add(monsterImg);



        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    //behövs denna??
    public String getSelectedItem() {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }

    public void addLvl1ComboboxListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }

    public void addLvl1ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
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
