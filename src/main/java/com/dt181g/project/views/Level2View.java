package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
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
    JTextField bucket1 = new JTextField(8);
    JTextField bucket2 = new JTextField(8);
    JTextField bucket3 = new JTextField(8);
    ActionListener listener;

    /**
     * @param viewFrame
     * @param monsterImg
     * @param name
     * @param listener
     */
    public Level2View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener listener) {

        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.listener = listener;

        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * @return
     */
    public List<Integer> getBuckets() {
        List<Integer> numbs = new ArrayList<>(Arrays.asList(Integer.parseInt(bucket1.getText()),
                Integer.parseInt(bucket2.getText()), Integer.parseInt(bucket3.getText())));
        return numbs;
    }

    /**
     * {@inheritDoc}
     */
    @Override
     void addTopPanel() {
        JLabel label = new JLabel("<html>Well hello there Hero. I might look super scary but I'm a nice monster<br>named " + name + ". " +
                "Can you help me with a problem? I've got three buckets<br> to carry my apples in, I need a total " +
                "amount of 15 apples, no more, no less.<br>How many apples should I place in each bucket?</html>");
        //label.setHorizontalAlignment(SwingConstants.CENTER);
        //label.setVerticalAlignment(SwingConstants.CENTER);
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
        centerPanel.setPreferredSize(new Dimension(900, 400));
        JLabel bucket1Label = new JLabel("Bucket 1:");
        bucket1Label.setForeground(Constants.COLOR_TEXT);
        bucket1Label.setFont(Constants.FONT_TEXT);
        JLabel bucket2Label = new JLabel("Bucket 2:");
        bucket2Label.setForeground(Constants.COLOR_TEXT);
        bucket2Label.setFont(Constants.FONT_TEXT);
        JLabel bucket3Label = new JLabel("Bucket 3:");
        bucket3Label.setForeground(Constants.COLOR_TEXT);
        bucket3Label.setFont(Constants.FONT_TEXT);
        centerPanel.setLayout(new GridLayout(3,3, 5, 0));
        bucket1.setFont(Constants.FONT_BIG);
        bucket2.setFont(Constants.FONT_BIG);
        bucket3.setFont(Constants.FONT_BIG);
        centerPanel.add(new JLabel(monsterImg));
        centerPanel.add(new JLabel(Constants.IMAGE_APPLE));
        centerPanel.add(new JLabel(Constants.IMAGE_BUCKET));
        centerPanel.add(bucket1Label);
        centerPanel.add(bucket2Label);
        centerPanel.add(bucket3Label);
        centerPanel.add(bucket1);
        centerPanel.add(bucket2);
        centerPanel.add(bucket3);
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
