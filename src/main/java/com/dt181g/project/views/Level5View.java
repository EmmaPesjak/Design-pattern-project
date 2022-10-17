package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 5 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class Level5View extends BaseView {
    private final ViewFrame viewFrame;
    private final JPanel bigPanel = new JPanel();
    private final MyPanel topPanel = new MyPanel();
    private final MyPanel centerPanel = new MyPanel();
    private final MyPanel bottomPanel = new MyPanel();
    private final JLabel healthLabel = new JLabel();
    private final ImageIcon monsterImg;
    private final String name;
    private final MyButton myButton = new MyButton("Channel crystal");
    private final ActionListener listener;

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the ImageIcon of the monster.
     * @param name is the name of the monster.
     * @param listener is the action listener for the button.
     */
    public Level5View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * Method for updating level 5 displaying the health and health bar of Vaelarya.
     * @param healthBarPanel is Vaelarya's health bar.
     * @param health is the amount of health represented by an integer.
     */
    public void updateLevel5 (HealthBarPanel healthBarPanel, int health) {
        bottomPanel.removeAll();
        healthLabel.setText("Vaelarya's health: " + health);
        healthLabel.setFont(Constants.FONT_BIG);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setForeground(Constants.COLOR_TEXT);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(healthLabel);
        bottomPanel.add(healthBarPanel);
        bottomPanel.revalidate();
        bottomPanel.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        topPanel.removeAll();
        JLabel label = new JLabel("<html>Hero! I am Vaelarya Vision Walker, the mighty dragon. A monster<br>" +
                "named " + name + " and his five friends are attacking me! Luckily<br>they only have a pool of three " +
                "weapons to share and take turns.<br>Grab that healing crystal and start channeling to heal me " +
                "above<br>" + Constants.VAELARYA_UPPER_HEALTH + " hp, quickly!</html>");
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
        centerPanel.removeAll();
        centerPanel.setPreferredSize(new Dimension(1000, 300));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(new JLabel(Constants.IMAGE_DRAGON));
        centerPanel.add(new JLabel(monsterImg));
        centerPanel.add(new JLabel(Constants.IMAGE_CRYSTAL));
        centerPanel.add(new JLabel(Constants.IMAGE_WEAPONS));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bottomPanel.removeAll();
        bottomPanel.setPreferredSize(new Dimension(1000, 120));
        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
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

    /**
     * {@inheritDoc}
     */
    @Override
    void addButtonListener() {
        myButton.addActionListener(listener);
    }

}
