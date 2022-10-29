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
    Color color;

    /**
     * Constructor that sets the amount of health.
     * @param amountOfHealth is the current amount of health Vaelarya has.
     */
    public HealthBarPanel(int amountOfHealth, Color color) {
        this.amountOfHealth = amountOfHealth;
        this.color = color;
    }

    /**
     * Overridden method responsible for painting the health bar with the current health.
     */
    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Draw a background colored rectangle in the background.
        g2D.setColor(Constants.COLOR_BACKGROUND);
        g2D.fillRect(0, 0, getWidth(), getHeight());

        // Draw the health bar, size depending on the resource amount.
        g2D.setColor(color);
        int x = this.getWidth()/2 - amountOfHealth;
        int y = this.getHeight()/2;
        g2D.fillRect(x, y, amountOfHealth * 2, 20);
    }
}
