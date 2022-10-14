package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 2 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class Level2View extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Help the monster");
    ImageIcon monsterImg;
    String name;
    Deque<JTextField> buckets = new LinkedList<>(Arrays.asList(
            new JTextField(8), new JTextField(8), new JTextField(8)));
    ActionListener listener;

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the ImageIcon of the monster.
     * @param name is the name of the monster.
     * @param listener is the action listener for the button.
     */
    public Level2View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * Method for accessing the user text field input.
     * @return a list of the text field inputs as integers.
     */
    public List<Integer> getBuckets() {
        List<Integer> integers = new ArrayList<>();
        for (JTextField bucket : buckets) {
            integers.add(Integer.parseInt(bucket.getText()));
        }
        return integers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
     void addTopPanel() {
        JLabel label = new JLabel("<html>Well hello there Hero. I might look super scary but I'm a nice monster<br>named " + name + ". " +
                "Can you help me with a problem? I've got three buckets<br> to carry my apples in, I need a total " +
                "amount of 15 apples, no more, no less.<br>How many apples should I place in each bucket?</html>");
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
        centerPanel.setPreferredSize(new Dimension(900, 400));
        centerPanel.setLayout(new GridLayout(3,3, 5, 0));
        centerPanel.add(new JLabel(monsterImg));
        centerPanel.add(new JLabel(Constants.IMAGE_APPLE));
        centerPanel.add(new JLabel(Constants.IMAGE_BUCKET));
        for (int i = 1; i <= 3; i++) {
            JLabel bucketLabel = new JLabel("Bucket " + i + ":");
            bucketLabel.setForeground(Constants.COLOR_TEXT);
            bucketLabel.setFont(Constants.FONT_TEXT);
            centerPanel.add(bucketLabel);
        }
        for (JTextField bucket : buckets) {
            bucket.setFont(Constants.FONT_BIG);
            centerPanel.add(bucket);
        }
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
