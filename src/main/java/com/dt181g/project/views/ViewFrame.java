package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Emma Pesjak
 */
public class ViewFrame extends JFrame {

    JPanel panel = new JPanel();

    /**
     *
     */
    public ViewFrame() {
        this.setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Constants.COLOR_BACKGROUND);
    }

    /**
     * @param top
     */
    public void updateView(JPanel top) {
        panel.removeAll();
        panel.add(top);
        this.add(panel);
        this.revalidate();
        this.repaint();
    }

    /**
     * @param errorMsg
     */
    public void displayErrorMsg (String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }
}
