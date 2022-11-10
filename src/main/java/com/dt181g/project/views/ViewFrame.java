package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;

/**
 * Frame component class, used for the GUI of the application.
 * @author Emma Pesjak
 */
public class ViewFrame extends JFrame {

    private final JPanel panel = new JPanel();

    /**
     * Constructor which sets the layout, size, background, and enabling program shut down of the GUI frame.
     */
    public ViewFrame() {
        setResizable(false);
        setSize(1000, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Constants.COLOR_BACKGROUND);
    }

    /**
     * Method for updating the frame with a new panel.
     * @param jPanel is the panel to be put in the frame.
     */
    public void updateView(JPanel jPanel) {
        panel.removeAll();
        panel.add(jPanel);
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Method for displaying error messages.
     * @param errorMsg is the error message string.
     */
    public void displayErrorMsg (String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
}
