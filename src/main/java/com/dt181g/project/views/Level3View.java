package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Deque;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * level 3 panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class Level3View extends BaseView {
    private final ViewFrame viewFrame;
    private final JPanel bigPanel = new JPanel();
    private final MyPanel topPanel = new MyPanel();
    private final MyPanel centerPanel = new MyPanel();
    private final MyPanel bottomPanel = new MyPanel();
    private final MyButton nextLevelBtn = new MyButton("Next level");
    private final MyButton produceBtn = new MyButton("Produce");
    private final String monsterImg;
    private final String name;
    private final ActionListener nextListener;

    /**
     * Constructor which sets the layout and takes needed arguments for the GUI.
     * @param viewFrame is the frame to display the panel in.
     * @param monsterImg is the String of the monster image path.
     * @param name is the name of the monster.
     * @param nextListener is the action listener for the 'Next' button.
     */
    public Level3View(ViewFrame viewFrame, String monsterImg, String name, ActionListener nextListener) {
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
     * @param images is the Deque of string image file paths of the produced characters.
     */
    public void updateLevel3(Deque<String> images) {
        centerPanel.removeAll();
        for (String s: images) {
            centerPanel.add(ImageReader.getImageFromFile(s, this));
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {
        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. " +
                "<br>This is my abstract factory. It creates factories <br>which can create unicorns or monsters. " +
                "Want to create<br> some totally random characters? Press the 'Produce' button" +
                "<br>as many times as you want, each time 5 new characters<br>will be produced, so cool!</html>");
        label.setFont(Constants.FONT_TEXT);
        label.setForeground(Constants.COLOR_TEXT);
        topPanel.add(label);
        topPanel.add(ImageReader.getImageFromFile(monsterImg, this));
        topPanel.add(ImageReader.getImageFromFile(Constants.IMAGE_FACTORY, this));
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
