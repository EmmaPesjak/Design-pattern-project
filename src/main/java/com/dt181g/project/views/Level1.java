package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Level1 extends BaseLevel {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    MyButton myButton = new MyButton("Next level");
    JLabel sentence = new JLabel();
    ImageIcon monsterImg;
    String name;
    String words;
    //lägga denna lista i constants?
    String[] sortFunctions = new String[] {"All words", "Sort alphabetically.", "Count words longer than 5 letters."};
    JComboBox<String> comboBox = new JComboBox<>(sortFunctions);
    ActionListener listener;

    public Level1(ViewFrame viewFrame, ImageIcon monsterImg, String name, String words, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.words = words;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    public void updateLevel1(String words) {
        centerPanel.removeAll();
        centerPanel.add(comboBox);


        centerPanel.add(new JLabel(monsterImg));

        JLabel wordLabel = new JLabel(words);
        wordLabel.setFont(Constants.FONT_TEXT);
        wordLabel.setForeground(Constants.COLOR_TEXT);
        //wordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        centerPanel.add(wordLabel);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public String getSelectedItem() {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }

    public void addLvl1ComboboxListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }

    @Override
    void addTopPanel() {
        topPanel.setBackground(Constants.COLOR_BACKGROUND);
        JLabel label = new JLabel("Hi, I'm " + name + ". I like words. These are my words. Want to play with them?");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    @Override
    void addCenterPanel() {
        centerPanel.setBackground(Constants.COLOR_BACKGROUND);
        centerPanel.setPreferredSize(new Dimension(1000, 400));
        centerPanel.add(comboBox);
        centerPanel.add(new JLabel(monsterImg));
        centerPanel.setBorder(new EmptyBorder(100, 5, 5,5));
        sentence.setText(words);
        sentence.setFont(Constants.FONT_TEXT);
        sentence.setForeground(Constants.COLOR_TEXT);
        centerPanel.add(sentence);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    @Override
    void addBottomPanel() {

        bottomPanel.setBackground(Constants.COLOR_BACKGROUND);
        //bottomPanel.setPreferredSize(new Dimension(1000, 120));
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
