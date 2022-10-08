package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level2 extends JPanel {

    MyButton myButton = new MyButton("Help the monster");

    JTextField bucket1 = new JTextField(8);
    JTextField bucket2 = new JTextField(8);
    JTextField bucket3 = new JTextField(8);

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public Level2(JLabel monsterImg, String name) {

        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);


        //denna är för streams.reduce()

        JLabel label = new JLabel("<html>Well hello there Hero. I might look super scary but I'm a nice monster named " + name + ".<br> " +
                "Can you help me with a problem? I've got three buckets to carry my apples in, I need a total <br>" +
                "amount of 15 apples, no more, no less. How many apples should I place in each bucket? </html>");
        label.setFont(Constants.TEXT_FONT);
        label.setForeground(Constants.TEXT_COLOR);
        topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(label);

        JLabel bucket1Label = new JLabel("Bucket 1:");
        bucket1Label.setForeground(Constants.TEXT_COLOR);
        bucket1Label.setFont(Constants.TEXT_FONT);
        JLabel bucket2Label = new JLabel("Bucket 2:");
        bucket2Label.setForeground(Constants.TEXT_COLOR);
        bucket2Label.setFont(Constants.TEXT_FONT);
        JLabel bucket3Label = new JLabel("Bucket 3:");
        bucket3Label.setForeground(Constants.TEXT_COLOR);
        bucket3Label.setFont(Constants.TEXT_FONT);
        centerPanel.setLayout(new GridLayout(3,3, 5, 0));
        bucket1.setFont(Constants.TITLE_FONT);
        bucket2.setFont(Constants.TITLE_FONT);
        bucket3.setFont(Constants.TITLE_FONT);
        centerPanel.add(monsterImg);
        centerPanel.add(Constants.IMAGE_APPLE);
        centerPanel.add(Constants.IMAGE_BUCKET);
        centerPanel.add(bucket1Label);
        centerPanel.add(bucket2Label);
        centerPanel.add(bucket3Label);
        centerPanel.add(bucket1);
        centerPanel.add(bucket2);
        centerPanel.add(bucket3);

        bottomPanel.add(myButton);
        myButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public List<Integer> getBuckets() {
        List<Integer> numbs = new ArrayList<>(Arrays.asList(Integer.parseInt(bucket1.getText()),
                Integer.parseInt(bucket2.getText()), Integer.parseInt(bucket3.getText())));
        return numbs;
    }

    public void addLvl2ButtonListener(ActionListener listener) {
        myButton.addActionListener(listener);
    }

    public JPanel getTopPanel(){
        return topPanel;
    }

    public JPanel getCenterPanel(){
        return centerPanel;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }
}
