package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;

/**
 * Panel component class, used or generic panels with the same background in the GUI.
 * @author Emma Pesjak
 */
public class MyPanel extends JPanel {

    /**
     * Constructor setting the background of the panel.
     */
    public MyPanel() {
        this.setBackground(Constants.COLOR_BACKGROUND);
    }
}
