package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Emma Pesjak
 */
public class StartView extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Start");
    ActionListener listener;

    /**
     * @param viewFrame
     * @param listener
     */
    public StartView(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.FONT_BIG);
        title.setForeground(Constants.COLOR_TEXT);
        topPanel.add(title);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(new JLabel(Constants.IMAGE_YELLOW_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_BLUE_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_RED_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_GREEN_MONSTER));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bottomPanel.add(myButton);
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
