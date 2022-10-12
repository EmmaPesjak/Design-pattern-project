package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 *
 * @author Emma Pesjak
 */
public class Level1View extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Next level");
    JLabel sentence = new JLabel();
    ImageIcon monsterImg;
    String name;
    String words;
    String[] sortFunctions = Constants.LVL1_SORT_LIST;
    JComboBox<String> comboBox = new JComboBox<>(sortFunctions);
    ActionListener listener;

    /**
     * @param viewFrame
     * @param monsterImg
     * @param name
     * @param words
     * @param listener
     */
    public Level1View(ViewFrame viewFrame, ImageIcon monsterImg, String name, String words, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.words = words;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * @param words
     */
    public void updateLevel1(String words) {
        centerPanel.removeAll();
        centerPanel.add(new JLabel(monsterImg));
        centerPanel.add(comboBox);
        JLabel wordLabel = new JLabel(words);
        wordLabel.setFont(Constants.FONT_TEXT);
        wordLabel.setForeground(Constants.COLOR_TEXT);
        centerPanel.add(wordLabel);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * @return
     */
    public String getSelectedItem() {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }

    /**
     * @param listener
     */
    public void addLvl1ComboboxListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        JLabel label = new JLabel("Hi, I'm " + name + ". I like words. These are my words. Want to play with them?");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        //topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {


        centerPanel.setPreferredSize(new Dimension(1000, 470));

        centerPanel.add(new JLabel(monsterImg));
        centerPanel.add(comboBox);

        centerPanel.setBorder(new EmptyBorder(150, 5, 5,5));
        sentence.setText(words);
        sentence.setFont(Constants.FONT_TEXT);
        sentence.setForeground(Constants.COLOR_TEXT);
        centerPanel.add(sentence);
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {

        //bottomPanel.setPreferredSize(new Dimension(1000, 120));
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addButtonListener() {
        myButton.addActionListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
