package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 4 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class Level4View extends BaseView {
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

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the ImageIcon of the monster.
     * @param name is the name of the monster.
     * @param listener is the action listener for the button.
     */
    public Level4View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * Method for checking if the user has selected the correct answer.
     * @return boolean if the radio button is checked.
     */
    public boolean rightAnswerLevel4() {
        return radioButton2.isSelected();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        JLabel label = new JLabel("<html>Hi, my name is " + name + " the Ugly Flesh Beast, long name I know.<br>I lost my brother" +
                " Rothead so now I'm sad. Can you cheer me up<br>by solving my riddle? What do you call a monster with a high IQ? </html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(label);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 400));
        centerPanel.setBorder(new EmptyBorder(120, 5, 5,5));
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

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
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
