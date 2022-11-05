package com.dt181g.project.views;

import javax.swing.*;

/**
 * Abstract base class of the GUI panel creation, makes the panel that is displayed by the frame,
 * implemented with the template method design pattern.
 * @author Emma Pesjak
 */
public abstract class BaseView extends JPanel {

    /**
     * Method responsible for creating the panel that will be displayed by the frame.
     * Generally a top, a center, and a bottom panel is added, also a button which has an action listener.
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
     * Method for adding a top panel.
     */
    abstract void addTopPanel();

    /**
     * Method for adding a center panel.
     */
    abstract void addCenterPanel();

    /**
     * Method for adding a bottom panel.
     */
    abstract void addBottomPanel();

    /**
     * Method for adding an action listener to a button.
     */
    abstract void addButtonListener();

    /**
     * Method for clearing and updating the panel displayed by the frame.
     */
    abstract void updatePanel();

    /**
     * Hook that can be overridden if topPanel is not used.
     * @return boolean if the hook is used.
     */
    boolean topPanelIsUsed() { return true; }

    /**
     * Hook that can be overridden if centerPanel is not used.
     * @return boolean if the hook is used.
     */
    boolean centerPanelIsUsed() { return true; }

    /**
     * Hook that can be overridden if bottomPanel is not used.
     * @return boolean if the hook is used.
     */
    boolean bottomPanelIsUsed() { return true; }

    /**
     * Hook that can be overridden if a button is not used.
     * @return boolean if the hook is used.
     */
    boolean buttonIsUsed() { return true; }
}
