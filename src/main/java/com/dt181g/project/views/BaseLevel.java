package com.dt181g.project.views;

import javax.swing.*;

//detta är ju template typ
public abstract class BaseLevel extends JPanel {

    public final void makePanel() {

        if (topPanelIsUsed()) {
            addTopPanel();
        }
        if (centerPanelIsUsed()) {
            addCenterPanel();
        }
        if (bottomPanelIsUsed()) {
            addBottomPanel();
        }

        updatePanel();
    }

    abstract void addTopPanel();
    abstract void addCenterPanel();
    abstract void addBottomPanel();

    //the hooks, can be overridden if top panel is not used, kanske ta bort dessa och sen skriva om hooks i readmen
    boolean topPanelIsUsed() { return true; }
    boolean centerPanelIsUsed() { return true; }
    boolean bottomPanelIsUsed() { return true; }

    abstract void updatePanel();

}
