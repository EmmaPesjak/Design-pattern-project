package com.dt181g.project.controllers;

import com.dt181g.project.models.*;
import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.models.threads.DamageThread;
import com.dt181g.project.models.threads.HealThread;
import com.dt181g.project.support.Constants;
import com.dt181g.project.views.*;
import com.dt181g.project.views.components.HealthBarPanel;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Class responsible for communicating with views and models, responding to user input.
 * @author Emma Pesjak
 */
public class Controller implements Observer {

    private final MainModel mainModel;
    private final ViewFrame viewFrame;
    private final Level1View level1View;
    private final Level2View level2View;
    private final Level3View level3View;
    private final Level4View level4View;
    private final Level5View level5View;
    private final Vaelarya vaelarya = new Vaelarya();
    private final HealThread healThread = new HealThread(vaelarya);
    private final DamageThread damageThread = new DamageThread(vaelarya);
    private final Deque<DamageThread> damageThreads = new LinkedList<>();
    private final Timer timer = new Timer(150, e -> {
        updateLevel5View();
    });

    /**
     * Controller constructor, responsible for initiating the different level views and displaying the start view.
     * @param viewFrame is the GUI frame of the application.
     * @param mainModel is the main model of the application.
     */
    public Controller(ViewFrame viewFrame, MainModel mainModel) {
        this.viewFrame = viewFrame;
        this.mainModel = mainModel;

        // Create monsters for each level.
        BaseCharacter monster1 = mainModel.getRandomMonster();
        BaseCharacter monster2 = mainModel.getRandomMonster();
        BaseCharacter monster3 = mainModel.getRandomMonster();
        BaseCharacter monster4 = mainModel.getRandomMonster();
        BaseCharacter monster5 = mainModel.getRandomMonster();

        // Initiate the different level views.
        level5View = new Level5View(viewFrame, monster5.getImg(), monster5.getName(),
                new Level5ButtonListener());
        level4View = new Level4View(viewFrame, monster4.getImg(), monster4.getName(),
                new Level4ButtonListener());
        level3View = new Level3View(viewFrame, monster3.getImg(), monster3.getName(),
                new NextLevelButtonListener(level4View));
        level3View.addProduceButtonListener(new Level3ButtonListenerProduce());
        level2View = new Level2View(viewFrame, monster2.getImg(), monster2.getName(),
                new Level2ButtonListener());
        level1View = new Level1View(viewFrame, monster1.getImg(), monster1.getName(),
                mainModel.level1RandomWords(), new NextLevelButtonListener(level2View));
        level1View.addLvl1ComboboxListener(new Level1ComboboxListener());
        StartView startView = new StartView(viewFrame, new NextLevelButtonListener(level1View));
        startView.makePanel();
    }

    /**
     * Initializes the level 5 simulation, creating and starting 6 DamageThreads (monster) and 1 HealThread
     * (the player channeling the crystal), starts the timer and observes the dragon Vaelarya.
     */
    public void initLevel5() {
        // Create damageThreads representing the monsters.
        for (int i = 1; i <= 6; i++) {
            Thread dThread = new Thread(damageThread);
            damageThreads.add(damageThread);
            dThread.start();
        }
        // Create a healThread representing the player.
        Thread hThread = new Thread(healThread);
        hThread.start();

        vaelarya.addObserver(this);
        timer.start();
    }

    /**
     * Method used by the timer for updating the GUI with the current health of Vaelarya.
     */
    public void updateLevel5View() {
        level5View.updateLevel5(new HealthBarPanel(vaelarya.getHealth(), vaelarya.getColor()), vaelarya.getHealth());
    }

    /**
     * Method for terminating damage and heal threads when the simulation is completed.
     */
    public void terminateThreads() {
        healThread.stopThread();

        for (DamageThread thread : damageThreads) {
            thread.stopThread();
        }
    }

    /**
     * Overridden synchronized method responsible for checking the current health of Vaelarya, ends the
     * simulation if the amount is above the set upper health or equal to or below 0.
     */
    @Override
    public synchronized void updateObservers() {
        int amountOfHealth = this.vaelarya.getHealth();

        if (amountOfHealth > Constants.VAELARYA_UPPER_HEALTH) {
            terminateThreads();
            timer.stop();
            EndView endView = new EndView(viewFrame, new QuitButtonListener(),
                    "You completed the game! Well done!", Constants.IMAGE_STAR);
            endView.makePanel();

        } else if (amountOfHealth <= 0) {
            terminateThreads();
            timer.stop();
            EndView endView = new EndView(viewFrame, new QuitButtonListener(),
                    "Game Over!", Constants.IMAGE_RED_MONSTER);
            endView.makePanel();
        }
    }

    /**
     * Inner class responsible for listening to the combobox of level 1 and updating the view
     * with the help of the model.
     */
    class Level1ComboboxListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(level1View.getSelectedItem(), Constants.LVL1_SORT_LIST.get(1))) {
                level1View.updateLevel1(mainModel.sortLevel1Alphabetically());
            } else if (Objects.equals(level1View.getSelectedItem(), Constants.LVL1_SORT_LIST.get(2))) {
                level1View.updateLevel1(mainModel.countWordsLevel1());
            } else {
                level1View.updateLevel1(mainModel.level1RandomWords());
            }
        }
    }

    /**
     * Inner class responsible for checking with the model if the user has answered correctly and either
     * initiating level 3 or displaying a message telling the user to try again.
     */
    class Level2ButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (mainModel.calculateLevel2(level2View.getBuckets())) {
                    level3View.makePanel();

                } else {
                    viewFrame.displayErrorMsg("Does not add up to " + Constants.RESULT_LVL2 + ", try again!");
                }
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                viewFrame.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    /**
     * Inner class responsible for telling the view to display produced characters from the model.
     */
    class Level3ButtonListenerProduce implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            // Create a deque of lists with random characters image paths and names.
            Deque<List<String>> stringLists = new LinkedList<>(Arrays.asList(mainModel.getRandomCharImgName(),
                    mainModel.getRandomCharImgName(), mainModel.getRandomCharImgName(),
                    mainModel.getRandomCharImgName(), mainModel.getRandomCharImgName()));

            // Create a deque of colors.
            Deque<Color> colorList = new LinkedList<>(Arrays.asList(mainModel.getRandomColor(),
                    mainModel.getRandomColor(), mainModel.getRandomColor(),
                    mainModel.getRandomColor(), mainModel.getRandomColor()));
            level3View.updateLevel3(stringLists, colorList);
        }
    }

    /**
     * Inner class responsible for checking if the user has answered correctly and either initiating level 5
     * or displaying a message telling the user to try again.
     */
    class Level4ButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (level4View.rightAnswerLevel4()) {
                level5View.makePanel();
            } else {
                viewFrame.displayErrorMsg("Wrong answer, try again.");
            }
        }
    }

    /**
     * Inner class responsible for initiating the level 5 simulation upon a button click.
     */
    class Level5ButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            initLevel5();
        }
    }


    /**
     * Inner class responsible for initiating the next level when clicking on a button.
     */
    static class NextLevelButtonListener implements ActionListener {
        BaseView view;

        /**
         * Constructor that sets the BaseView.
         * @param view is the BaseView to be initiated next.
         */
        public NextLevelButtonListener(BaseView view) {
            this.view = view;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            view.makePanel();
        }
    }

    /**
     * Inner class responsible for enabling the program to shut down when pressing a 'quit' button.
     */
    static class QuitButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
