package com.dt181g.project.views;


import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

// denna till typ template method?
public class MyView extends JFrame {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    MyButton infoButton = new MyButton("Info");
    MyButton startButton = new MyButton("Start");
    MyButton lvlBbtn = new MyButton("Channel crystal");
    MyButton lvlAbtn = new MyButton("NÄSTA");
    MyButton lvlDbtn = new MyButton("Help the monster");
    MyButton lvlCbtn = new MyButton("Check answer");
    MyButton nextButton = new MyButton("Continue your journey");

    //JTextField bucket1 = new JTextField(8);
   // JTextField bucket2 = new JTextField(8);
  //  JTextField bucket3 = new JTextField(8);

    //JRadioButton radioButton1 = new JRadioButton("Rothead");
   // JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
  //  JRadioButton radioButton3 = new JRadioButton("Partygut");

    JLabel healthLabel = new JLabel();

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

    public void levelBetween() {
        clearAll();

        JLabel completed = new JLabel("You completed the level! Well done!");
        completed.setFont(Constants.TITLE_FONT);
        completed.setForeground(Constants.TEXT_COLOR);
        topPanel.add(completed);

        centerPanel.add(Constants.IMAGE_STAR);

        bottomPanel.add(nextButton);
        nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        revalidateRepaint();
    }

    public void updateView(JPanel topPanel, JPanel centerPanel, JPanel bottomPanel) {
        //clearAll();
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        //revalidateRepaint();
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
        nextButton.addActionListener(listener);
    }

    public void addlvlAButtonListener(ActionListener listener) {
        lvlAbtn.addActionListener(listener);
    }

    public void addlvlBButtonListener(ActionListener listener) {
        lvlBbtn.addActionListener(listener);
    }

    public void addlvlCButtonListener(ActionListener listener) {
        lvlCbtn.addActionListener(listener);
    }

    public void addlvlDButtonListener(ActionListener listener) {
        lvlDbtn.addActionListener(listener);
    }

    //public void addNextButtonListener(ActionListener listener) {
       // nextButton.addActionListener(listener);
    //}

    public MyButton getLvlAbtn() {
        return lvlAbtn;
    }

    public MyButton getLvlBbtn(){
        return lvlBbtn;
    }

    public MyButton getLvlCbtn() {
        return lvlCbtn;
    }

    public MyButton getLvlDbtn() {
        return lvlDbtn;
    }
}
