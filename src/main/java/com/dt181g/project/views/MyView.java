package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyView extends JFrame {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    MyButton infoButton = new MyButton("Info");
    MyButton startButton = new MyButton("Start");
    MyButton quitButton = new MyButton("Quit game");

    public MyView() {
        initView();
    }

    public void initView() {

        // General layout
        this.setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel.setPreferredSize(new Dimension(1000, 160));
        centerPanel.setPreferredSize(new Dimension(1000, 460));
        bottomPanel.setPreferredSize(new Dimension(1000, 80));

        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);

        //lägga till hero selection? så får man en till Jcomponent

        // Top panel
        topPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TEXT_COLOR);
        topPanel.add(title);

        // Center panel
        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_YELLOW_MONSTER);
        centerPanel.add(Constants.IMAGE_BLUE_MONSTER);
        centerPanel.add(Constants.IMAGE_RED_MONSTER);
        centerPanel.add(Constants.IMAGE_GREEN_MONSTER);

        // Bottom panel
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(infoButton);
        bottomPanel.add(startButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void gameFinished() {
        clearAll();

        JLabel completed = new JLabel("You completed the game! Well done!");
        completed.setFont(Constants.TITLE_FONT);
        completed.setForeground(Constants.TEXT_COLOR);
        topPanel.add(completed);

        centerPanel.add(Constants.IMAGE_STAR);

        bottomPanel.add(quitButton);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        revalidateRepaint();
    }

    public void updateView(Level1 level1) {
        clearAll();
        this.add(level1, BorderLayout.CENTER);
        revalidateRepaint();
    }

    public void clearAll() {
        topPanel.removeAll();
        centerPanel.removeAll();
        bottomPanel.removeAll();
    }

    public void revalidateRepaint() {
        topPanel.revalidate();
        topPanel.repaint();
        centerPanel.revalidate();
        centerPanel.repaint();
        bottomPanel.revalidate();
        bottomPanel.repaint();
    }

    public void displayErrorMsg (String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addQuitButtonListener(ActionListener listener) {
        quitButton.addActionListener(listener);
    }
}
