package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Level3View extends BaseView {

    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton nextLevelBtn = new MyButton("Next level");
    MyButton produceBtn = new MyButton("Produce");
    ImageIcon monsterImg;
    String name;
    ActionListener nextListener;

    public Level3View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener nextListener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.nextListener = nextListener;

        bigPanel.setLayout(new BorderLayout());
    }

    public void addProduceButtonListener(ActionListener listener) {
        produceBtn.addActionListener(listener);
    }

    public void updateLevel3(ImageIcon char1, ImageIcon char2, ImageIcon char3, ImageIcon char4, ImageIcon char5) {

        centerPanel.removeAll();
        centerPanel.add(new JLabel(char1));
        centerPanel.add(new JLabel(char2));
        centerPanel.add(new JLabel(char3));
        centerPanel.add(new JLabel(char4));
        centerPanel.add(new JLabel(char5));

        centerPanel.revalidate();
        centerPanel.repaint();
    }


    @Override
    void addTopPanel() {

        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. <br>This is my abstract factory. " +
                "It creates factories <br>which can create unicorns or monsters. " +
                "Want to create<br> some totally random characters? Press the 'Produce' button<br>as many times as you want, " +
                "each time 5 new characters<br>will be produced, so cool!</html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(label);
        topPanel.add(new JLabel(monsterImg));
        topPanel.add(new JLabel(Constants.IMAGE_FACTORY));
        bigPanel.add(topPanel, BorderLayout.NORTH);


    }

    @Override
    void addCenterPanel() {
        bigPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setPreferredSize(new Dimension(1000, 300));
        centerPanel.setBorder(new EmptyBorder(150, 5, 5,5));
    }

    @Override
    void addBottomPanel() {
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);

        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(produceBtn);
        bottomPanel.add(nextLevelBtn);

    }

    @Override
    void addButtonListener() {
        nextLevelBtn.addActionListener(nextListener);
    }

    @Override
    void updatePanel() {
        this.revalidate();
        this.repaint();
        viewFrame.updateView(bigPanel);
    }
}
