package com.dt181g.project.views;

import com.dt181g.project.support.Constants;
import com.dt181g.project.views.components.ImageReader;
import com.dt181g.project.views.components.MyButton;
import com.dt181g.project.views.components.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * start panel displayed in the GUI frame.
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
     * Constructor which sets the layout and takes needed GUI arguments.
     * @param viewFrame is the frame to display the panel in.
     * @param listener is the action listener for the button.
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
        centerPanel.setPreferredSize(new Dimension(1000, 400));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(ImageReader.getImageFromFile(Constants.IMAGE_YELLOW_MONSTER, this));
        centerPanel.add(ImageReader.getImageFromFile(Constants.IMAGE_BLUE_MONSTER, this));
        centerPanel.add(ImageReader.getImageFromFile(Constants.IMAGE_RED_MONSTER, this));
        centerPanel.add(ImageReader.getImageFromFile(Constants.IMAGE_GREEN_MONSTER, this));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        JLabel info = new JLabel("<html>This game takes you through 5 thrilling levels where you<br>encounter" +
                " monsters, some are friendly and some are very<br>dangerous. Thread carefully hero. </html>");
        info.setFont(Constants.FONT_TEXT);
        info.setForeground(Constants.COLOR_TEXT);
        bottomPanel.add(info);
        bottomPanel.add(myButton);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setHorizontalAlignment(SwingConstants.CENTER);
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
