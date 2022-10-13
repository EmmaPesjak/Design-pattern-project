package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 3 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
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

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the ImageIcon of the monster.
     * @param name is the name of the monster.
     * @param nextListener is the action listener for the 'Next' button.
     */
    public Level3View(ViewFrame viewFrame, ImageIcon monsterImg, String name, ActionListener nextListener) {
        this.viewFrame = viewFrame;
        this.monsterImg = monsterImg;
        this.name = name;
        this.nextListener = nextListener;
        bigPanel.setLayout(new BorderLayout());
    }

    /**
     * Method for adding a button listener to the 'Produce' button.
     * @param listener is the action listener for the button.
     */
    public void addProduceButtonListener(ActionListener listener) {
        produceBtn.addActionListener(listener);
    }

    /**
     * Method for updating level 3 displaying the five produced characters.
     * @param char1 is the image of character 1.
     * @param char2 is the image of character 2.
     * @param char3 is the image of character 3.
     * @param char4 is the image of character 4.
     * @param char5 is the image of character 5.
     */
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

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        bigPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setPreferredSize(new Dimension(1000, 300));
        centerPanel.setBorder(new EmptyBorder(150, 5, 5,5));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(produceBtn);
        bottomPanel.add(nextLevelBtn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addButtonListener() {
        nextLevelBtn.addActionListener(nextListener);
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
