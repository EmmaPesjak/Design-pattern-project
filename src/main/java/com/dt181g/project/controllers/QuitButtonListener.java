package com.dt181g.project.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitButtonListener implements ActionListener {
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
