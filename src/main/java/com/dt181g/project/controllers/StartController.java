package com.dt181g.project.controllers;

import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.StartView;

public class StartController {

    private final StartView startView;
    private final StartModel startModel;

    public StartController(StartView startView, StartModel startModel) {

        this.startView = startView;
        this.startModel = startModel;
    }
}
