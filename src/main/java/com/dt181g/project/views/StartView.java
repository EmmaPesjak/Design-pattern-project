package com.dt181g.project.views;

import com.dt181g.project.HealPool;
import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

    //public static final StartView INSTANCE = new StartView();

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    MyButton infoButton = new MyButton("Info");
    MyButton startButton = new MyButton("Start");
    MyButton redButton = new MyButton("Channel crystal");
    MyButton blueButton = new MyButton("NÄSTA");
    MyButton yellowButton = new MyButton("Help the monster");
    MyButton greenButton = new MyButton("Check answer");
    MyButton nextButton = new MyButton("Continue your journey");

    JTextField bucket1 = new JTextField(8);
    JTextField bucket2 = new JTextField(8);
    JTextField bucket3 = new JTextField(8);

    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");

    JLabel healthLabel = new JLabel();

    //går ej
    // private final List<JPanel> panelList =
            //new ArrayList<>(Arrays.asList(topPanel, centerPanel, bottomPanel));

    public StartView() {

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

        frontPage();

        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public void frontPage() {

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

    public void levelComplete() {
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

    public void blueLevel() {



        clearAll();

        JLabel redLabel = new JLabel("HEJ");
        redLabel.setFont(Constants.TEXT_FONT);
        redLabel.setForeground(Constants.TEXT_COLOR);
        topPanel.add(redLabel);

        centerPanel.add(Constants.IMAGE_BLUE_MONSTER);

        bottomPanel.add(blueButton);
        blueButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        revalidateRepaint();

    }

    public void redLevel() {

        //observer och producer/consumer

        clearAll();

        JLabel row1 = new JLabel("Hero! I am Vaelarya Vision Walker, the mighty dragon. Some monsters are attacking me!");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Grab that healing crystal and start channeling to heal me, quickly!");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);

        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(Constants.IMAGE_DRAGON);
        centerPanel.add(Constants.IMAGE_RED_MONSTER);
        centerPanel.add(Constants.IMAGE_CRYSTAL);

        //lägg till fler monsterbilder här

        bottomPanel.add(redButton);
        redButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        revalidateRepaint();
    }

    public void updateRedLevel(HealthPoolPanel healthPoolPanel, int health) {

        // skriva ut monsternas skada?

        bottomPanel.removeAll();
        healthLabel.setText("Vaelarya's health: " + health);
        healthLabel.setFont(Constants.TITLE_FONT);
        healthLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        healthLabel.setForeground(Constants.TEXT_COLOR);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(healthLabel);
        bottomPanel.add(healthPoolPanel);

        revalidateRepaint();
    }

    public void greenLevel() {


        clearAll();

        JLabel row1 = new JLabel("Hi, my name is Partygut the Ugly Flesh Beast, long name I know. I lost my brother");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Rothead so now I'm sad. Can you cheer me up by solving my riddle?");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        JLabel row3 = new JLabel("What do you call a monster with a high IQ?");
        row3.setFont(Constants.TEXT_FONT);
        row3.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);
        topPanel.add(row3);

        // man kan välja alla radio buttons???
        radioButton1.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton1.setForeground(Constants.TEXT_COLOR);
        radioButton1.setFont(Constants.TEXT_FONT);
        radioButton2.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton2.setForeground(Constants.TEXT_COLOR);
        radioButton2.setFont(Constants.TEXT_FONT);
        radioButton3.setBackground(Constants.COLOR_MIDNIGHT);
        radioButton3.setForeground(Constants.TEXT_COLOR);
        radioButton3.setFont(Constants.TEXT_FONT);
        GridBagLayout gridBagLayout = new GridBagLayout();
        centerPanel.setLayout(gridBagLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(Constants.IMAGE_GREEN_MONSTER, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(radioButton1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(radioButton2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        centerPanel.add(radioButton3, gbc);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        bottomPanel.add(greenButton);
        greenButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        revalidateRepaint();
    }

    public boolean rightAnswerFrank() {
        return radioButton2.isSelected();
    }

    public void yellowLevel() {
        //denna är för streams.reduce()

        clearAll();

        JLabel row1 = new JLabel("Well hello there Hero. I might look super scary but I'm a nice monster. You look like a smart");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("one, can you help me with a problem? I've got three buckets to carry my apples in, I need a total");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        JLabel row3 = new JLabel("amount of 15 apples, no more, no less. How many apples should I place in each bucket?");
        row3.setFont(Constants.TEXT_FONT);
        row3.setForeground(Constants.TEXT_COLOR);
        topPanel.setBorder(new EmptyBorder(5, 5, 5,5));
        topPanel.add(row1);
        topPanel.add(row2);
        topPanel.add(row3);

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
        centerPanel.add(Constants.IMAGE_YELLOW_MONSTER);
        centerPanel.add(Constants.IMAGE_APPLE);
        centerPanel.add(Constants.IMAGE_BUCKET);
        centerPanel.add(bucket1Label);
        centerPanel.add(bucket2Label);
        centerPanel.add(bucket3Label);
        centerPanel.add(bucket1);
        centerPanel.add(bucket2);
        centerPanel.add(bucket3);

        bottomPanel.add(yellowButton);
        yellowButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        revalidateRepaint();
    }

    public void gameFinished() {

    }

    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addBlueButtonListener(ActionListener listener) {
        blueButton.addActionListener(listener);
    }

    public void addRedButtonListener(ActionListener listener) {
        redButton.addActionListener(listener);
    }

    public void addGreenButtonListener(ActionListener listener) {
        greenButton.addActionListener(listener);
    }

    public void addYellowButtonListener(ActionListener listener) {
        yellowButton.addActionListener(listener);
    }

    public void addNextButtonListener(ActionListener listener) {
        nextButton.addActionListener(listener);
    }



    public void displayErrorMsg (String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }

    public int getNumb1Yellow() {
        return Integer.parseInt(bucket1.getText());
    }

    public int getNumb2Yellow() {
        return Integer.parseInt(bucket2.getText());
    }

    public int getNumb3Yellow() {
        return Integer.parseInt(bucket3.getText());
    }
}
