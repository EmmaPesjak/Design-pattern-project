package com.dt181g.project.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Emma Pesjak
 */
public class QuitButtonListener implements ActionListener {

    /**
     *
     * @param e is the action event of a click on the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
