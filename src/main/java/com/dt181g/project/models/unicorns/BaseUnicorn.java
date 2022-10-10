package com.dt181g.project.models.unicorns;

import javax.swing.*;

public abstract class BaseUnicorn {

    private ImageIcon unicornImg;
    private String power;

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public ImageIcon getUnicornImg() {
        return unicornImg;
    }

    public void setUnicornImg(ImageIcon unicornImg) {
        this.unicornImg = unicornImg;
    }
}
