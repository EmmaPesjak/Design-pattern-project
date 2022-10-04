package com.dt181g.project.controllers;

import com.dt181g.project.models.StartModel;
import com.dt181g.project.views.StartView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            if (startView.rightAnswerFrank()) {
                startView.blueLevel();
            } else {
                startView.displayErrorMsg("Wrong answer, try again.");
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
                List<Integer> numbs = new ArrayList<>(Arrays.asList(startView.getNumb1Yellow(),
                        startView.getNumb2Yellow(), startView.getNumb3Yellow()));
                startModel.calculateYellow(numbs);

                if (startModel.yellowSuccess()) {
                    startView.levelComplete();
                } else {
                    startView.displayErrorMsg("Does not add up to 15, try again!");
                }

            } catch (NumberFormatException exception) {
                System.out.println(exception);
                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }
}
