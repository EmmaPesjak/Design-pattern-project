package com.dt181g.project.controllers;

import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.StartView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartController {

    private final StartView startView;
    private final StartModel startModel;

    public StartController(StartView startView, StartModel startModel) {

        this.startView = startView;
        this.startModel = startModel;

        this.startView.addStartButtonListener(new StartButtonListener());
        this.startView.addRedButtonListener(new RedButtonListener());
        this.startView.addGreenButtonListener(new GreenButtonListener());
        this.startView.addYellowButtonListener(new YellowButtonListener());
        this.startView.addBlueButtonListener(new BlueButtonListener());
    }

    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startView.redLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class RedButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startView.greenLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class GreenButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startView.blueLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class BlueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startView.yellowLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class YellowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                startView.redLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }
}
