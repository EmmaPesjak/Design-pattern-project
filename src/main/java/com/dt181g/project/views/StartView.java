package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class StartView extends JFrame {

    // Till images, sen addar man dem til en panel
    ImageIcon yellowMonster = new ImageIcon("img/monsters/yellowMonster.png");
    JLabel yellowMonsterImg = new JLabel(yellowMonster);
    ImageIcon blueMonster = new ImageIcon("img/monsters/blueMonster.png");
    JLabel blueMonsterImg = new JLabel(blueMonster);
    ImageIcon greenMonster = new ImageIcon("img/monsters/greenMonster.png");
    JLabel greenMonsterImg = new JLabel(greenMonster);
    ImageIcon redMonster = new ImageIcon("img/monsters/redMonster.png");
    JLabel redMonsterImg = new JLabel(redMonster);
    ImageIcon apple = new ImageIcon("img/apple.png");
    JLabel appleImg = new JLabel(apple);
    ImageIcon bucket = new ImageIcon("img/bucket.png");
    JLabel bucketImg = new JLabel(bucket);
    ImageIcon dragon = new ImageIcon("img/dragon.png");
    JLabel dragonImg = new JLabel(dragon);
    ImageIcon crystal = new ImageIcon("img/crystal.png");
    JLabel crystalImg = new JLabel(crystal);
    ImageIcon star = new ImageIcon("img/star.png");
    JLabel starImg = new JLabel(star);

    JButton infoButton = new JButton("Info");
    JButton startButton = new JButton("Start");

    JButton redButton = new JButton("Channel crystal");
    JButton blueButton = new JButton("NÄSTA");
    JButton yellowButton = new JButton("Help the monster");
    JButton greenButton = new JButton("Check answer");
    JButton nextButton = new JButton("Continue your journey");

    JTextField bucket1 = new JTextField(8);
    JTextField bucket2 = new JTextField(8);
    JTextField bucket3 = new JTextField(8);

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    JRadioButton radioButton1 = new JRadioButton("Rothead");
    JRadioButton radioButton2 = new JRadioButton("Frank-Einstein");
    JRadioButton radioButton3 = new JRadioButton("Partygut");

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
        // Top panel
        topPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.TITLE_FONT);
        title.setForeground(Constants.TEXT_COLOR);
        topPanel.add(title);

        // Center panel
        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(yellowMonsterImg);
        centerPanel.add(blueMonsterImg);
        centerPanel.add(redMonsterImg);
        centerPanel.add(greenMonsterImg);

        // Bottom panel
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(infoButton);
        bottomPanel.add(startButton);
        startButton.setFont(Constants.BUTTON_FONT);
        startButton.setBackground(Constants.BUTTON_COLOR);
        startButton.setForeground(Constants.BUTTON_TEXT_COLOR);
        infoButton.setFont(Constants.BUTTON_FONT);
        infoButton.setBackground(Constants.BUTTON_COLOR);
        infoButton.setForeground(Constants.BUTTON_TEXT_COLOR);
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

        JLabel completed = new JLabel("You did it! Well done!");
        completed.setFont(Constants.TITLE_FONT);
        completed.setForeground(Constants.TEXT_COLOR);
        topPanel.add(completed);

        centerPanel.add(starImg);

        bottomPanel.add(nextButton);
        nextButton.setFont(Constants.BUTTON_FONT);
        nextButton.setBackground(Constants.BUTTON_COLOR);
        nextButton.setForeground(Constants.BUTTON_TEXT_COLOR);

        revalidateRepaint();
    }

    public void blueLevel() {

        clearAll();

        JLabel redLabel = new JLabel("HEJ");
        redLabel.setFont(Constants.TEXT_FONT);
        redLabel.setForeground(Constants.TEXT_COLOR);
        topPanel.add(redLabel);

        centerPanel.add(blueMonsterImg);

        bottomPanel.add(blueButton);
        revalidateRepaint();

    }

    public void redLevel() {

        //observer och producer/consumer

        clearAll();

        JLabel row1 = new JLabel("Hero! I am Vaelarya Vision Walker, the mighty dragon. A monster is attacking me!");
        row1.setFont(Constants.TEXT_FONT);
        row1.setForeground(Constants.TEXT_COLOR);
        JLabel row2 = new JLabel("Grab that healing crystal and start channeling to heal me, quickly!");
        row2.setFont(Constants.TEXT_FONT);
        row2.setForeground(Constants.TEXT_COLOR);
        topPanel.add(row1);
        topPanel.add(row2);

        centerPanel.setBorder(new EmptyBorder(40, 100, 20, 100));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(dragonImg);
        centerPanel.add(redMonsterImg);
        // Här ska healing producer/consumer in
        centerPanel.add(crystalImg);


        bottomPanel.add(redButton);
        redButton.setFont(Constants.BUTTON_FONT);
        redButton.setBackground(Constants.BUTTON_COLOR);
        redButton.setForeground(Constants.BUTTON_TEXT_COLOR);

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
        centerPanel.add(greenMonsterImg, gbc);
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
        greenButton.setFont(Constants.BUTTON_FONT);
        greenButton.setBackground(Constants.BUTTON_COLOR);
        greenButton.setForeground(Constants.BUTTON_TEXT_COLOR);

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
        centerPanel.add(yellowMonsterImg);
        centerPanel.add(appleImg);
        centerPanel.add(bucketImg);
        centerPanel.add(bucket1Label);
        centerPanel.add(bucket2Label);
        centerPanel.add(bucket3Label);
        centerPanel.add(bucket1);
        centerPanel.add(bucket2);
        centerPanel.add(bucket3);

        bottomPanel.add(yellowButton);
        yellowButton.setFont(Constants.BUTTON_FONT);
        yellowButton.setBackground(Constants.BUTTON_COLOR);
        yellowButton.setForeground(Constants.BUTTON_TEXT_COLOR);

        revalidateRepaint();
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
