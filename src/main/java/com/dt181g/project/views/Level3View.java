package com.dt181g.project.views;

import com.dt181g.project.support.Constants;
import com.dt181g.project.views.components.ImageReader;
import com.dt181g.project.views.components.MyButton;
import com.dt181g.project.views.components.MyPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Deque;
import java.util.List;

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
     * Method for updating level 3 displaying the five produced characters with backgrounds.
     * @param charLists is the deque of the characters lists of string image file paths and names.
     * @param colors is the deque of colors.
     */
    public void updateLevel3(Deque<List<String>> charLists, Deque<Color> colors) {
        centerPanel.removeAll();
        for (Color color: colors) {         // Loop over the deque of colors.
            JPanel panel = new JPanel();    // Create a panel.
            panel.setBackground(color);     // Set the background.
            List<String> character = charLists.pollFirst();     // Poll a character.
            assert character != null;
            String image = character.get(0);                    // Get the image path file.
            String name = character.get(1);                     // Get the name.
            panel.add(ImageReader.getImageFromFile(image, this)); // Add the image to the panel.
            JLabel nameLabel = new JLabel(name);
            nameLabel.setFont(Constants.FONT_TEXT);
            nameLabel.setForeground(Constants.COLOR_TEXT);
            panel.add(nameLabel);                               // Add the name to the panel.
            centerPanel.add(panel);
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTopPanel() {
        JLabel label = new JLabel("<html>" + name + " is my name, nice to meet you hero. This is" +
                " my<br>abstract factory. It creates moster factories and unicorn<br>factories. " +
                "Each factory produces colors and characters.<br>" +
                "Want to create some totally random characters with<br>random background colors? " +
                "Press the 'Produce' button<br>" +
                "as many times as you want, each time 5 new characters<br>" +
                "will be produced, so cool!</html>");
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
    public void addCenterPanel() {
        bigPanel.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setPreferredSize(new Dimension(1000, 300));
        centerPanel.setBorder(new EmptyBorder(150, 5, 5,5));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBottomPanel() {
        bigPanel.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.add(produceBtn);
        bottomPanel.add(nextLevelBtn);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addButtonListener() {
        nextLevelBtn.addActionListener(nextListener);
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
