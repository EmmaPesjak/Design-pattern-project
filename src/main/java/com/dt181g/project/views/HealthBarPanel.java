package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Panel component class, used to represent the health bar of Vaelarya the dragon.
 * @author Emma Pesjak
 */
public class HealthBarPanel extends JPanel {

    int amountOfHealth;

    /**
     * Constructor that sets the amount of health.
     * @param amountOfHealth is the current amount of health Vaelarya has.
     */
    public HealthBarPanel(int amountOfHealth) {
        this.amountOfHealth = amountOfHealth;
    }

    /**
     * Overridden method responsible for painting the health bar with the current health.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Draw a black rectangle in the background.
        g2D.setColor(Constants.COLOR_BACKGROUND);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        // Set color of pool depending on the resource amount.
        if (amountOfHealth < Constants.VAELARYA_UPPER_HEALTH/4) {
            g2D.setColor(Constants.COLOR_LOW_HEALTH);
        } else if (amountOfHealth < Constants.VAELARYA_UPPER_HEALTH/2) {
            g2D.setColor(Constants.COLOR_MEDIUM_LOW_HEALTH);
        } else if (amountOfHealth < Constants.VAELARYA_UPPER_HEALTH*3/4) {
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
