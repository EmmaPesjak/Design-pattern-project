package com.dt181g.project.views;

import javax.swing.*;

//detta är ju template typ
public abstract class BaseView extends JPanel {

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
        if (buttonIsUsed()) {
            addButtonListener();
        }

        updatePanel();
    }

    abstract void addTopPanel();
    abstract void addCenterPanel();
    abstract void addBottomPanel();
    abstract void addButtonListener();

    //the hooks, can be overridden panels/buttons not used, kanske ta bort dessa och sen skriva om hooks i readmen
    boolean topPanelIsUsed() { return true; }
    boolean centerPanelIsUsed() { return true; }
    boolean bottomPanelIsUsed() { return true; }
    boolean buttonIsUsed() { return true; }

    abstract void updatePanel();

}
