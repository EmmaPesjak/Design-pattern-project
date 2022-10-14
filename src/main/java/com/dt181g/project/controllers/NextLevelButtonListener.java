package com.dt181g.project.controllers;

import com.dt181g.project.views.BaseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Emma Pesjak
 */
public class NextLevelButtonListener implements ActionListener {
    BaseView view;

    /**
     * @param view
     */
    public NextLevelButtonListener(BaseView view) {
        this.view = view;
    }

    /**
     * @param e is the action event of a click on the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        view.makePanel();
    }
}
