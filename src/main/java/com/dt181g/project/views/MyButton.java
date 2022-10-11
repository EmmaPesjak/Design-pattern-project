package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String text) {
        this.setText(text);
        this.setBackground(Constants.COLOR_BUTTON);
        this.setFont(Constants.FONT_BUTTON);
        this.setForeground(Constants.COLOR_BUTTON_TEXT);
    }
}
