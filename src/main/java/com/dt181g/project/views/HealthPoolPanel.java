package com.dt181g.project.views;


import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

public class HealthPoolPanel extends JPanel {

    int amountOfHealth;

    public HealthPoolPanel (int amountOfHealth) {
        this.amountOfHealth = amountOfHealth;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Draw a black rectangle in the background.
        g2D.setColor(Constants.COLOR_MIDNIGHT);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        // Set colour of pool depending on the resource amount.
        if (amountOfHealth < 50) {
            g2D.setColor(Color.RED);
        } else if (amountOfHealth < 100) {
            g2D.setColor(Color.YELLOW);
        } else if (amountOfHealth < 150) {
            g2D.setColor(Color.GREEN);
        } else {
            g2D.setColor(Color.BLUE);
        }

        // Draw the pool, size depending on the resource amount.
        int x = this.getWidth()/2 - amountOfHealth/2;
        int y = this.getHeight()/2 - amountOfHealth/2;
        g2D.fillOval(x, y, amountOfHealth, amountOfHealth);
    }
}
