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
 *
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

    /**
     * @param viewFrame
     * @param mainModel
     */
    public Controller(ViewFrame viewFrame, MainModel mainModel) {
        this.viewFrame = viewFrame;
        this.mainModel = mainModel;

        BaseMonster monster1 = mainModel.getRandomMonster();
        BaseMonster monster2 = mainModel.getRandomMonster();
        BaseMonster monster3 = mainModel.getRandomMonster();
        BaseMonster monster4 = mainModel.getRandomMonster();
        BaseMonster monster5 = mainModel.getRandomMonster();

        StartView startView = new StartView(viewFrame, new StartButtonListener());
        startView.makePanel();
        level1View = new Level1View(viewFrame, monster1.getMonsterImg(), monster1.getName(), mainModel.lvl1RandomWords(), new Level1ButtonListener());
        level1View.addLvl1ComboboxListener(new Level1ComboboxListener());
        level2View = new Level2View(viewFrame, monster2.getMonsterImg(), monster2.getName(), new Level2ButtonListener());
        level3View = new Level3View(viewFrame, monster3.getMonsterImg(), monster3.getName(), new Level3ButtonListenerNext());
        level3View.addProduceButtonListener(new Level3ButtonListenerProduce());
        level4View = new Level4View(viewFrame, monster4.getMonsterImg(), monster4.getName(), new Level4ButtonListener());
        level5View = new Level5View(viewFrame, monster5.getMonsterImg(), monster5.getName(), new Level5ButtonListener());
    }

    /**
     *
     */
    class Level1ComboboxListener implements ActionListener {
        /**
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(level1View.getSelectedItem(), "Sort alphabetically.")) {
                level1View.updateLevel1(mainModel.sortLvl1Alphabetically());
            } else if ((Objects.equals(level1View.getSelectedItem(), "Count words longer than 5 letters."))) {
                level1View.updateLevel1(mainModel.countWordsLvl1());
            } else {
                level1View.updateLevel1(mainModel.lvl1RandomWords());
            }
        }
    }

    /**
     *
     */
    class StartButtonListener implements ActionListener {
        /**
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            level1View.makePanel();
        }
    }

    /**
     *
     */
    class Level1ButtonListener implements ActionListener {
        /**
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            level2View.makePanel();
        }
    }

    /**
     *
     */
    class Level2ButtonListener implements ActionListener {
        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                mainModel.calculateLvl2(level2View.getBuckets());

                if (mainModel.lvl2Success()) {
                    level3View.makePanel();

                } else {
                    viewFrame.displayErrorMsg("Does not add up to 15, try again!");
                }

            } catch (NumberFormatException exception) {
                System.out.println(exception);
                viewFrame.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    /**
     *
     */
    class Level3ButtonListenerNext implements ActionListener {

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            level4View.makePanel();
        }
    }

    /**
     *
     */
    class Level3ButtonListenerProduce implements ActionListener {
        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            level3View.updateLevel3(mainModel.getRandomCharImg(), mainModel.getRandomCharImg(),
                    mainModel.getRandomCharImg(), mainModel.getRandomCharImg(), mainModel.getRandomCharImg());
        }
    }

    /**
     *
     */
    class Level4ButtonListener implements ActionListener {

        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (level4View.rightAnswerFrank()) {
                level5View.makePanel();
            } else {
                viewFrame.displayErrorMsg("Wrong answer, try again.");
            }
        }
    }

    /**
     *
     */
    class Level5ButtonListener implements ActionListener {
        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            init();
        }
    }

    /**
     *
     */
    static class QuitButtonListener implements ActionListener {
        /**
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }



    //observerskit, var ska detta vara??????
    Vaelarya vaelarya = Vaelarya.INSTANCE;

    //public static final ObserverThing INSTANCE = new ObserverThing(HealPool.INSTANCE);
    private final HealThread healThread = new HealThread();
    private final DamageThread damageThread = new DamageThread();
    private final Deque<DamageThread> damageThreads = new LinkedList<>();
    Timer timer = new Timer(150, e -> {
        updateGUI();
    });

    public void init() {
        // Create damageThreads representing the monsters.
        for (int i = 1; i <= 6; i++) {
            createDamageThread();
        }
        // Create a healThread representing the player.
        createHealer();

        vaelarya.addObserver(this);
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void updateGUI() {
        level5View.updateLevel5(new HealthBarPanel(vaelarya.getHealth()), vaelarya.getHealth());
    }

    public void createHealer () {
        Thread thread = new Thread(healThread);
        thread.start();
    }

    public void createDamageThread() {

        Thread thread = new Thread(damageThread);
        damageThreads.add(damageThread);
        thread.start();
    }

    public void terminateThreads() {
        healThread.stopThread();

        for (DamageThread thread : damageThreads) {
            thread.stopThread();
        }
    }

    @Override
    public synchronized void update() {
        int amountOfHealth = this.vaelarya.getHealth();

        if (amountOfHealth > 170) {
            terminateThreads();
            stopTimer();
            EndView endView = new EndView(viewFrame, new QuitButtonListener(), "You completed the game! Well done!", Constants.IMAGE_STAR);
            endView.makePanel();

        } else if (amountOfHealth <= 0) {
            terminateThreads();
            stopTimer();
            EndView endView = new EndView(viewFrame, new QuitButtonListener(), "Game Over!", Constants.IMAGE_RED_MONSTER);
            endView.makePanel();
        }
    }
}
