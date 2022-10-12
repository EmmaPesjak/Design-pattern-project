package com.dt181g.project;

import com.dt181g.project.controllers.Controller;
import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.ViewFrame;

/**
 *
 * @author Emma Pesjak
 */
public final class Project {

    /**
     *
     */
    private Project() { }

    /**
     * @param args
     */
    public static void main(final String... args) {
        ViewFrame viewFrame = new ViewFrame();
        StartModel startModel = new StartModel();
        Controller controller = new Controller(viewFrame, startModel);
    }
}
