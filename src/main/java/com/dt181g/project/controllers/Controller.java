package com.dt181g.project.controllers;

import com.dt181g.project.models.DamageThread;
import com.dt181g.project.models.Vaelarya;
import com.dt181g.project.models.HealThread;
import com.dt181g.project.models.MainModel;
import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.support.Constants;
import com.dt181g.project.views.*;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

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
    private final Vaelarya vaelarya = Vaelarya.INSTANCE;
    private final HealThread healThread = new HealThread();
    private final DamageThread damageThread = new DamageThread();
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
        BaseMonster monster1 = mainModel.getRandomMonster();
        BaseMonster monster2 = mainModel.getRandomMonster();
        BaseMonster monster3 = mainModel.getRandomMonster();
        BaseMonster monster4 = mainModel.getRandomMonster();
        BaseMonster monster5 = mainModel.getRandomMonster();

        // Initiate the different level views.
        level5View = new Level5View(viewFrame, monster5.getMonsterImg(), monster5.getName(),
                new Level5ButtonListener());
        level4View = new Level4View(viewFrame, monster4.getMonsterImg(), monster4.getName(),
                new Level4ButtonListener());
        level3View = new Level3View(viewFrame, monster3.getMonsterImg(), monster3.getName(),
                new NextLevelButtonListener(level4View));
        level3View.addProduceButtonListener(new Level3ButtonListenerProduce());
        level2View = new Level2View(viewFrame, monster2.getMonsterImg(), monster2.getName(),
                new Level2ButtonListener());
        level1View = new Level1View(viewFrame, monster1.getMonsterImg(), monster1.getName(),
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
        level5View.updateLevel5(new HealthBarPanel(vaelarya.getHealth()), vaelarya.getHealth());
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
     * Inner class responsible for checking if the user has answered correctly and either initiating level 3
     * or displaying a message telling the user to try again.
     */
    class Level2ButtonListener implements ActionListener {

        /**
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                mainModel.calculateLevel2(level2View.getBuckets());

                if (mainModel.level2Success()) {
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
            Deque<String> imageList = new LinkedList<>(Arrays.asList(mainModel.getRandomCharImg(),
                    mainModel.getRandomCharImg(), mainModel.getRandomCharImg(),
                    mainModel.getRandomCharImg(), mainModel.getRandomCharImg()));
            level3View.updateLevel3(imageList);
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
}
