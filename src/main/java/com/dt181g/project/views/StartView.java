package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;

/**
 * Concrete view of {@link com.dt181g.project.views.BaseView} responsible for setting up the
 * start panel displayed in the GUI frame.
 * @author Emma Pesjak
 */
public class StartView extends BaseView {
    ViewFrame viewFrame;
    JPanel bigPanel = new JPanel();
    MyPanel topPanel = new MyPanel();
    MyPanel centerPanel = new MyPanel();
    MyPanel bottomPanel = new MyPanel();
    MyButton myButton = new MyButton("Start");
    ActionListener listener;

    /**
     * Constructor which sets the layout and takes needed GUI arguments.
     * @param viewFrame is the frame to display the panel in.
     * @param listener is the action listener for the button.
     */
    public StartView(ViewFrame viewFrame, ActionListener listener) {
        this.viewFrame = viewFrame;
        this.listener = listener;
        bigPanel.setLayout(new BorderLayout());


    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addTopPanel() {

       // URL imageurl = getClass().getResource("/src/main/java/com/dt181g/project/img/monsters/yellowMonster.png");//assuming your package name is images
       // Image myPicture = Toolkit.getDefaultToolkit().getImage(imageurl);
       // JLabel piclabel = new JLabel(new ImageIcon( myPicture ));

        //ImageIcon hej = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("src/main/java/com/dt181g/project/img/monsters/yellowMonster.png")));
        //InputStream stream = this.getClass().getResourceAsStream("/src/main/java/com/dt181g/project/img/monsters/yellowMonster.png");
        //ImageIcon hej = new ImageIcon(stream.toString());
        //ImageIcon hej = new ImageIcon(getClass().getResource("src/main/java/com/dt181g/project/img/monsters/yellowMonster.png"));

        JLabel title = new JLabel("The Monster Game");
        title.setFont(Constants.FONT_BIG);
        title.setForeground(Constants.COLOR_TEXT);
        topPanel.add(title);
        //topPanel.add(new JLabel(hej));
        //topPanel.add(piclabel);

        bigPanel.add(topPanel, BorderLayout.NORTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addCenterPanel() {
        centerPanel.setPreferredSize(new Dimension(1000, 400));
        centerPanel.setLayout(new GridLayout(2,2, 5, 5));
        centerPanel.add(new JLabel(Constants.IMAGE_YELLOW_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_BLUE_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_RED_MONSTER));
        centerPanel.add(new JLabel(Constants.IMAGE_GREEN_MONSTER));
        bigPanel.add(centerPanel, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void addBottomPanel() {
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        JLabel info = new JLabel("<html>This game takes you through 5 thrilling levels where you<br>encounter" +
                " monsters, some are friendly and some are very<br>dangerous. Thread carefully hero. </html>");
        info.setFont(Constants.FONT_TEXT);
        info.setForeground(Constants.COLOR_TEXT);
        bottomPanel.add(info);
        bottomPanel.add(myButton);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);
        info.setHorizontalAlignment(SwingConstants.CENTER);
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
