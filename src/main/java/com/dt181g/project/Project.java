package com.dt181g.project;

import com.dt181g.project.controllers.NewController;
import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.StartView;

public final class Project {

    private Project() { }

    public static void main(final String... args) {
//        StartView startView = new StartView();
//        StartModel startModel = new StartModel();
//        StartController startController = new StartController(startView, startModel);


        StartView startView = new StartView();
        StartModel startModel = new StartModel();
        NewController newController = new NewController(startView, startModel);


    }
}
