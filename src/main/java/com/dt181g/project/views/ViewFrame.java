package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

//startframe döpa om?
public class ViewFrame extends JFrame {

    JPanel topPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel bottomPanel = new JPanel();

    public ViewFrame() {
        this.setLayout(new BorderLayout());
        setResizable(false);
        setSize(1000, 650);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel.setBackground(Constants.COLOR_MIDNIGHT);
        centerPanel.setBackground(Constants.COLOR_MIDNIGHT);
        bottomPanel.setBackground(Constants.COLOR_MIDNIGHT);
    }

    public void updateView(JPanel top, JPanel center, JPanel bottom) {
        clearAll();

        topPanel.add(top);
        this.add(topPanel, BorderLayout.NORTH);

        centerPanel.add(center);
        this.add(centerPanel, BorderLayout.CENTER);

        bottomPanel.add(bottom);
        this.add(bottomPanel, BorderLayout.SOUTH);

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

}
