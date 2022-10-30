package com.dt181g.project.views.components;

import com.dt181g.project.support.Constants;

import javax.swing.*;

/**
 * Button component class, used for generic buttons in the GUI.
 * @author Emma Pesjak
 */
public class MyButton extends JButton {

    /**
     * Constructor setting design of the button.
     * @param text is the text displayed in the button.
     */
    public MyButton(String text) {
        this.setText(text);
        this.setBackground(Constants.COLOR_BUTTON);
        this.setFont(Constants.FONT_BUTTON);
        this.setForeground(Constants.COLOR_BUTTON_TEXT);
    }
}
