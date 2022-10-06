package com.dt181g.project.views;

import com.dt181g.project.support.Constants;

import javax.swing.*;
import java.awt.*;

public class LevelBetween extends MyView {

    public LevelBetween() {
        clearAll();

        JLabel completed = new JLabel("You completed the level! Well done!");
        completed.setFont(Constants.TITLE_FONT);
        completed.setForeground(Constants.TEXT_COLOR);
        topPanel.add(completed);

        centerPanel.add(Constants.IMAGE_STAR);

        bottomPanel.add(quitButton);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        revalidateRepaint();
    }
}
