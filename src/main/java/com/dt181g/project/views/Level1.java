package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Level1 extends JPanel {

    MyButton myButton = new MyButton("NÄSTA");

    JLabel sentence = new JLabel();

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    String[] sortFunctions = new String[] {"All words", "Sort alphabetically.", "Count words longer than 5 letters."};
    JComboBox<String> comboBox = new JComboBox<>(sortFunctions);

    JLabel monsterImg;

    public Level1(JLabel monsterImg, String name, String words) {

        this.monsterImg = monsterImg;

        sentence.setText(words);

        topPanel.setPreferredSize(new Dimension(1000, 160));
        centerPanel.setPreferredSize(new Dimension(1000, 460));
        bottomPanel.setPreferredSize(new Dimension(1000, 80));
        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);


        JLabel label = new JLabel("Hi, I'm " + name + ". I like words. These are my words. Want to play with them?");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(label);

        centerPanel.add(comboBox);
        centerPanel.add(monsterImg);

        sentence.setFont(Constants.TEXT_FONT);
        sentence.setForeground(Constants.TEXT_COLOR);
        centerPanel.add(sentence);

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void updateLevel1(String words) {

        centerPanel.removeAll();
        centerPanel.add(comboBox);
        centerPanel.add(monsterImg);

        JLabel wordLabel = new JLabel(words);
        wordLabel.setFont(Constants.TEXT_FONT);
        wordLabel.setForeground(Constants.TEXT_COLOR);
        //wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(wordLabel);
        centerPanel.revalidate();
        centerPanel.repaint();
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
