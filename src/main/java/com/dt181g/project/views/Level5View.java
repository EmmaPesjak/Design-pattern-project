package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Emma Pesjak
 */
public class Level5View extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    JLabel healthLabel = new JLabel();
    ImageIcon monsterImg;
    String name;
    MyButton myButton = new MyButton("Channel crystal");
    ActionListener listener;


    //OBS MÅSTE FIXA NÅGON OM HON SKULLE DÖ


    /**
     * @param viewFrame
     * @param monsterImg
     * @param name
     * @param listener
     */
    public Level5View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * @param healthPoolPanel
     * @param health
     */
    public void updateLevel5 (HealthPoolPanel healthPoolPanel, int health) {
        // skriva ut monsternas skada?
        bottomPanel.removeAll();
        healthLabel.setText("Vaelarya's health: " + health);
        healthLabel.setFont(Constants.FONT_BIG);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setForeground(Constants.COLOR_TEXT);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(healthLabel);
        bottomPanel.add(healthPoolPanel);
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
                "weapons to share and take turns.<br>Grab that healing crystal and start channeling to heal me above<br>" +
                "170 hp, quickly!</html>");
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
