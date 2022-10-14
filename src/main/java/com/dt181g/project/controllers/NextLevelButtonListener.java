package com.dt181g.project.controllers;

import com.dt181g.project.views.BaseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextLevelButtonListener implements ActionListener {
    BaseView view;

    /**
     * @param view
     */
    public NextLevelButtonListener(BaseView view) {
        this.view = view;
    }

    /**
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        view.makePanel();
    }
}
