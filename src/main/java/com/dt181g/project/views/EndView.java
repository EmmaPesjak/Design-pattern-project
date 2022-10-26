package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * end of game panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class EndView extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Quit game");
    ActionListener listener;
    String text;
    String img;

    /**
     * Constructor which sets the layout and takes needed GUI arguments.
     * @param viewFrame is the frame to display the panel in.
     * @param listener is the action listener for the button.
     * @param text is the text to be displayed.
     * @param img is the image string file path.
     */
    public EndView(ViewFrame viewFrame, ActionListener listener, String text, String img) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        this.text = text;
        this.img = img;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        topPanel.removeAll();
        JLabel completed = new JLabel(text);
        completed.setFont(Constants.FONT_BIG);
        completed.setForeground(Constants.COLOR_TEXT);
        topPanel.add(completed);
        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        centerPanel.removeAll();
        centerPanel.setPreferredSize(new Dimension(1000, 470));
        centerPanel.setBorder(new EmptyBorder(120, 5, 5,5));
        centerPanel.add(GetImageFromFile.getImageFromFile(img, this));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bottomPanel.removeAll();
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
