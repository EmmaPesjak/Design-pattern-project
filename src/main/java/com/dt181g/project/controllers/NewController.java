package com.dt181g.project.controllers;

import com.dt181g.project.DamageThread;
import com.dt181g.project.HealPool;
import com.dt181g.project.HealThread;
import com.dt181g.project.Observer;
import com.dt181g.project.models.StartModel;
import com.dt181g.project.models.monsters.BaseMonster;
import com.dt181g.project.views.*;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class NewController implements Observer {

    private final MyView myView;
    private final StartModel startModel;

    private final Level1 level1;
    private final Level2 level2;
    private final Level3 level3;
    private final Level4 level4;


    public NewController(MyView myView, StartModel startModel) {
        this.myView = myView;
        this.startModel = startModel;

        this.myView.addStartButtonListener(new StartButtonListener());
        this.myView.addQuitButtonListener(new QuitButtonListener());

        BaseMonster monster1 = startModel.getRandomMonster();
        BaseMonster monster2 = startModel.getRandomMonster();
        BaseMonster monster3 = startModel.getRandomMonster();
        BaseMonster monster4 = startModel.getRandomMonster();

        level1 = new Level1(monster1.getMonsterImg(), monster1.getName());
        level2 = new Level2(monster2.getMonsterImg(), monster2.getName());
        level3 = new Level3(monster3.getMonsterImg(), monster3.getName());
        level4 = new Level4(monster4.getMonsterImg(), monster4.getName());

        level1.addLvl1ButtonListener(new Level1ButtonListener());
        level2.addLvl2ButtonListener(new Level2ButtonListener());
        level3.addLvl3ButtonListener(new Level3ButtonListener());
        level4.addLvl4ButtonListener(new Level4ButtonListener());
    }


    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            myView.updateView(level1);
        }
    }

    class Level1ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            myView.updateView(level1);
        }
    }

    class Level2ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                List<Integer> numbs = new ArrayList<>(Arrays.asList(level2.getBucket1(),
                        level2.getBucket2(), level2.getBucket3()));
                startModel.calculateLevel2(numbs);

                if (startModel.level2Success()) {
                    myView.updateView(level1);
                } else {
                    myView.displayErrorMsg("Does not add up to 15, try again!");
                }

            } catch (NumberFormatException exception) {
                System.out.println(exception);
                myView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class Level3ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (level3.rightAnswerFrank()) {
                myView.updateView(level1);
            } else {
                myView.displayErrorMsg("Wrong answer, try again.");
            }
        }
    }

    class Level4ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            GUITimer();
            init();
        }
    }

    class QuitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //quitta spelet
            System.out.println("hej nu är det slut i rutan");
        }
    }




    //observerskit, flytta mög till model???
    HealPool healPool = HealPool.INSTANCE;

    //public static final ObserverThing INSTANCE = new ObserverThing(HealPool.INSTANCE);
    private final HealThread healThread = new HealThread();
    private final DamageThread damageThread = new DamageThread();

    Timer timer = new Timer(150, e -> {
        updateGUI();
    });

    private final Deque<DamageThread> damageThreads = new LinkedList<>();

    public void init() {
        for (int i = 1; i <= 6; i++) {
            createDamageMonster();
        }
        createHealer();
        healPool.addObserver(this);
    }

    public void GUITimer() {
        //Timer timer = new Timer(1000, e -> {
        //updateGUI();
        //});
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void updateGUI() {
        //startView.updateRedLevel(new HealthPoolPanel(healPool.getHealth()), healPool.getHealth());
    }

    public void createHealer () {
        Thread thread = new Thread(healThread);
        thread.start();
    }

    public void createDamageMonster() {

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
        int amountOfHealth = this.healPool.getHealth();

        if (amountOfHealth > 170) {
            terminateThreads();
            stopTimer();
            myView.gameFinished();
        }
    }
}
