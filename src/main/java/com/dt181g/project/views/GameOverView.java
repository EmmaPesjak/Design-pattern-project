package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Emma Pesjak
 */
public class GameOverView extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Quit game");
    ActionListener listener;

    /**
     * @param viewFrame
     * @param listener
     */
    public GameOverView(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        JLabel gameOver = new JLabel("Game Over!");
        gameOver.setFont(Constants.FONT_BIG);
        gameOver.setForeground(Constants.COLOR_TEXT);
        topPanel.add(gameOver);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setBorder(new EmptyBorder(120, 5, 5,5));
        centerPanel.add(new JLabel(Constants.IMAGE_RED_MONSTER));
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
    void updatePanel() {

        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
