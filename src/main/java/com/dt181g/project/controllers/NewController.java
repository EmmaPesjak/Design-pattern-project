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

    //LevelFactory levelFactory = new LevelFactory();


    public NewController (MyView myView, StartModel startModel) {
        this.myView = myView;
        this.startModel = startModel;

        this.myView.addStartButtonListener(new StartButtonListener());
        //this.myView.addNextButtonListener(new NextButtonListener());
        this.myView.addlvlBButtonListener(new RedButtonListener());
        this.myView.addlvlCButtonListener(new LvlCListener());
        this.myView.addlvlDButtonListener(new YellowButtonListener());
        this.myView.addlvlAButtonListener(new BlueButtonListener());
    }


    //detta kan man kanske göra i model
    public BaseLevel createLevel(int nmb){

        BaseMonster monster = startModel.getRandomMonster();

        if (nmb == 1) {
            return new LevelA(monster, myView.getLvlAbtn());
        } else if (nmb == 2) {
            return new LevelB(monster, myView.getLvlBbtn());
        } else if (nmb == 3) {
            return new LevelC(monster, myView.getLvlCbtn());
        } else {
            return new LevelD(monster, myView.getLvlDbtn());
        }

    }

    public void getNextLevel(){
        int nmb = new Random().nextInt(4) + 1;
        BaseLevel baseLevel = createLevel(nmb);
        myView.clearAll();
        myView.updateView(baseLevel.getTopPanel(), baseLevel.getCenterPanel(), baseLevel.getBottomPanel());
        myView.revalidateRepaint();
    }


    class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getNextLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                myView.displayErrorMsg("hej.");
            }
        }
    }

//    class NextButtonListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                int nmb = new Random().nextInt(4) + 1;
//                BaseLevelView baseLevelView = createLevel(nmb);
//                myView.updateView(baseLevelView.getTopPanel(), baseLevelView.getCenterPanel(), baseLevelView.getBottomPanel());
//            } catch (NumberFormatException exception) {
//                System.out.println(exception);
//                myView.displayErrorMsg("hej.");
//            }
//        }
//    }

    class RedButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                GUITimer();
                init();
                getNextLevel();

            } catch (NumberFormatException exception) {
                System.out.println(exception);
                myView.displayErrorMsg("hej.");
            }
        }
    }

    class LvlCListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (true) {
                getNextLevel();
            } else {
                myView.displayErrorMsg("Wrong answer, try again.");
            }
        }
    }

    class BlueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                getNextLevel();
            } catch (NumberFormatException exception) {
                System.out.println(exception);
                myView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
        }
    }

    class YellowButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
//                List<Integer> numbs = new ArrayList<>(Arrays.asList(startView.getNumb1Yellow(),
//                        startView.getNumb2Yellow(), startView.getNumb3Yellow()));
//                startModel.calculateYellow(numbs);
//
//                if (startModel.yellowSuccess()) {
//                    startView.levelComplete();
//                } else {
//                    startView.displayErrorMsg("Does not add up to 15, try again!");
//                }

                getNextLevel();

            } catch (NumberFormatException exception) {
                System.out.println(exception);
                myView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
            }
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
            myView.levelBetween();
        }
    }
}
