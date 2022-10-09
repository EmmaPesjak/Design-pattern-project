package com.dt181g.project.models.unicorns;

import javax.swing.*;

public abstract class BaseUnicorn {

    private JLabel unicornImg;
    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public JLabel getUnicornImg() {
        return unicornImg;
    }

    public void setUnicornImg(JLabel unicornImg) {
        this.unicornImg = unicornImg;
    }
}
