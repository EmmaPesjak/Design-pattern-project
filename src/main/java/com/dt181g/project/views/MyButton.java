package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;

public class MyButton extends JButton {

    public MyButton(String text) {
        this.setText(text);
        this.setBackground(Constants.BUTTON_COLOR);
        this.setFont(Constants.BUTTON_FONT);
        this.setForeground(Constants.BUTTON_TEXT_COLOR);
    }
}
