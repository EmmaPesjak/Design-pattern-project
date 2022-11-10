package com.dt181g.project.views;

import com.dt181g.project.support.Constants;
import com.dt181g.project.views.components.ImageReader;
import com.dt181g.project.views.components.MyButton;
import com.dt181g.project.views.components.MyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 1 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class Level1View extends BaseView {
    private final ViewFrame viewFrame;
    private final JPanel bigPanel = new JPanel();
    private final MyPanel topPanel = new MyPanel();
    private final MyPanel centerPanel = new MyPanel();
    private final MyPanel bottomPanel = new MyPanel();
    private final MyButton myButton = new MyButton("Next level");
    private final JLabel sentence = new JLabel();
    private final String monsterImg;
    private final String name;
    private final String words;
    private final JComboBox<String> comboBox = new JComboBox<>();
    private final ActionListener listener;

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the String of the monster image path.
     * @param name is the name of the monster.
     * @param words is the string of words to be displayed and used by the user.
     * @param listener is the action listener for the button.
     */
    public Level1View(ViewFrame viewFrame, String monsterImg, String name, String words, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.words = words;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());

        ArrayList<String> sortFunctions = Constants.LVL1_SORT_LIST;
        for (String s : sortFunctions) {
            comboBox.addItem(s);
        }
    }

    /**
     * Method for updating level 1 displaying the altered words.
     * @param words is the string of words that has been altered.
     */
    public void updateLevel1(String words) {
        centerPanel.removeAll();
        centerPanel.add(ImageReader.getImageFromFile(monsterImg, this));
        centerPanel.add(comboBox);
        JLabel wordLabel = new JLabel(words);
        wordLabel.setFont(Constants.FONT_TEXT);
        wordLabel.setForeground(Constants.COLOR_TEXT);
        centerPanel.add(wordLabel);
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * Method for adding an action listener to the combobox.
     * @param listener is the action listener.
     */
    public void addLvl1ComboboxListener(ActionListener listener) {
        comboBox.addActionListener(listener);
    }

    /**
     * Method for getting the selected item from the combobox.
     * @return the string of the selected item.
     */
    public String getSelectedItem() {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTopPanel() {
        JLabel label = new JLabel("Hi, I'm " + name + ". I like words. " +
                "These are my words. Want to play?");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.add(ImageReader.getImageFromFile(monsterImg, this));
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
    public void addBottomPanel() {
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addButtonListener() {
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
