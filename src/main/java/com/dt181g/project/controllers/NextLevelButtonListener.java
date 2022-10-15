package com.dt181g.project.controllers;

import com.dt181g.project.views.BaseView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class responsible for initiating the next level when clicking on a button.
 * @author Emma Pesjak
 */
public class NextLevelButtonListener implements ActionListener {
    BaseView view;

    /**
     * Constructor that sets the BaseView.
     * @param view is the BaseView to be initiated next.
     */
    public NextLevelButtonListener(BaseView view) {
        this.view = view;
    }

    /**
     * Method for initiating another BaseView, and thereby starting another level.
     * @param e is the action event of a click on the button.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        view.makePanel();
    }
}
