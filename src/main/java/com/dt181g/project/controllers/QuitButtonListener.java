package com.dt181g.project.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class responsible for enabling the program to shut down when pressing a 'quit' button.
 * @author Emma Pesjak
 */
public class QuitButtonListener implements ActionListener {

    /**
     * Method that shuts down the program.
     * @param e is the action event of a click on the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
