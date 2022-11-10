package com.dt181g.project;

import com.dt181g.project.controllers.Controller;

import javax.swing.*;

/**
 * The main starting point for the project. Responsible for triggering the game.
 * @author Emma Pesjak
 */
public final class Project {

    /**
     * Private constructor.
     */
    private Project() { }

    /**
     * Create the Controller to start the game.
     * @param args are command arguments. Not relevant here.
     */
    public static void main(final String... args) {
        SwingUtilities.invokeLater(Controller::new);
    }
}
