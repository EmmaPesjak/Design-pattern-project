package com.dt181g.project;

import com.dt181g.project.controllers.Controller;
import com.dt181g.project.models.MainModel;
import com.dt181g.project.views.ViewFrame;

import javax.swing.*;

/**
 * The main starting point for the project. Responsible for initiating the GUI and triggering the game.
 * @author Emma Pesjak
 */
public final class Project {

    /**
     * Private constructor.
     */
    private Project() { }

    /**
     * Create the MVC entities to start the game.
     * @param args are command arguments. Not relevant here.
     */
    public static void main(final String... args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ViewFrame viewFrame = new ViewFrame();
                MainModel mainModel = new MainModel();
                Controller controller = new Controller(viewFrame, mainModel);
            }
        });
    }
}
