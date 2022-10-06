package com.dt181g.project;

import com.dt181g.project.controllers.StartController;
import com.dt181g.project.models.StartModel;
import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.views.StartView;

public final class Project {

    private Project() { }

    public static void main(final String... args) {
        StartView startView = new StartView();
        StartModel startModel = new StartModel();
        StartController startController = new StartController(startView, startModel);



    }
}
