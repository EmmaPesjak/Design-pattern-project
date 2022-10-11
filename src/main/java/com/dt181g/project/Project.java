package com.dt181g.project;

import com.dt181g.project.controllers.Controller;
import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.ViewFrame;

public final class Project {

    private Project() { }

    public static void main(final String... args) {
//        StartView startView = new StartView();
//        StartModel startModel = new StartModel();
//        StartController startController = new StartController(startView, startModel);


        ViewFrame viewFrame = new ViewFrame();
        StartModel startModel = new StartModel();
        Controller controller = new Controller(viewFrame, startModel);


    }
}
