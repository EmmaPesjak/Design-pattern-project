package com.dt181g.project.views;

import javax.swing.*;

//detta är ju template typ
/**
 *
 * @author Emma Pesjak
 */
public abstract class BaseView extends JPanel {

    /**
     *
     */
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

    /**
     *
     */
    abstract void addTopPanel();

    /**
     *
     */
    abstract void addCenterPanel();

    /**
     *
     */
    abstract void addBottomPanel();

    /**
     * hello
     */
    abstract void addButtonListener();




    //the hooks, can be overridden panels/buttons not used, kanske ta bort dessa och sen skriva om hooks i readmen
    /**
     *
      * @return
     */
    boolean topPanelIsUsed() { return true; }

    /**
     *
     * @return
     */
    boolean centerPanelIsUsed() { return true; }

    /**
     *
     * @return
     */
    boolean bottomPanelIsUsed() { return true; }

    /**
     * hello
     * @return
     */
    boolean buttonIsUsed() { return true; }

    /**
     *
     */
    abstract void updatePanel();

}
