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
            g2D.setColor(Constants.COLOR_LOW_HEALTH);
        } else if (amountOfHealth < 100) {
            g2D.setColor(Constants.COLOR_MEDIUM_LOW_HEALTH);
        } else if (amountOfHealth < 150) {
            g2D.setColor(Constants.COLOR_MEDIUM_HEALTH);
        } else {
            g2D.setColor(Constants.COLOR_HIGH_HEALTH);
        }

        // Draw the pool, size depending on the resource amount.
        int x = this.getWidth()/2 - amountOfHealth;
        int y = this.getHeight()/2;
        g2D.fillRect(x, y, amountOfHealth * 2, 20);
    }
}
