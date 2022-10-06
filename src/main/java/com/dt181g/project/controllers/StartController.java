//package com.dt181g.project.controllers;
//
//import com.dt181g.project.*;
//import com.dt181g.project.Observer;
//import com.dt181g.project.models.StartModel;
//import com.dt181g.project.views.HealthPoolPanel;
//import com.dt181g.project.views.StartView;
//
//import javax.swing.Timer;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.*;
//
//public class StartController implements Observer {
//
//    private final StartView startView;
//    private final StartModel startModel;
//
//    public StartController(StartView startView, StartModel startModel) {
//
//        this.startView = startView;
//        this.startModel = startModel;
//
//        this.startView.addStartButtonListener(new StartButtonListener());
//        this.startView.addRedButtonListener(new RedButtonListener());
//        this.startView.addGreenButtonListener(new GreenButtonListener());
//        this.startView.addYellowButtonListener(new YellowButtonListener());
//        this.startView.addBlueButtonListener(new BlueButtonListener());
//        this.startView.addNextButtonListener(new NextButtonListener());
//    }
//
//    class NextButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            startView.greenLevel(startModel.getRandomMonster().getMonsterImg());
//        }
//    }
//
//    class StartButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            startView.blueLevel(startModel.getRandomMonster().getMonsterImg());
//        }
//    }
//
//    class RedButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            GUITimer();
//            init();
//
//        }
//    }
//
//    class GreenButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            if (startView.rightAnswerFrank()) {
//                startView.yellowLevel(startModel.getRandomMonster().getMonsterImg());
//            } else {
//                startView.displayErrorMsg("Wrong answer, try again.");
//            }
//        }
//    }
//
//    class BlueButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                startView.redLevel(startModel.getRandomMonster().getMonsterImg());
//            } catch (NumberFormatException exception) {
//                System.out.println(exception);
//                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
//            }
//        }
//    }
//
//    class YellowButtonListener implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            try {
//                List<Integer> numbs = new ArrayList<>(Arrays.asList(startView.getNumb1Yellow(),
//                        startView.getNumb2Yellow(), startView.getNumb3Yellow()));
//                startModel.calculateLevel2(numbs);
//
//                if (startModel.level2Success()) {
//                    startView.levelComplete();
//                } else {
//                    startView.displayErrorMsg("Does not add up to 15, try again!");
//                }
//
//            } catch (NumberFormatException exception) {
//                System.out.println(exception);
//                startView.displayErrorMsg("Please fill in all boxes, and only with numbers.");
//            }
//        }
//    }
//
//
//
//
//    //observerskit, flytta mög till model???
//    HealPool healPool = HealPool.INSTANCE;
//
//    //public static final ObserverThing INSTANCE = new ObserverThing(HealPool.INSTANCE);
//    private final HealThread healThread = new HealThread();
//    private final DamageThread damageThread = new DamageThread();
//
//    Timer timer = new Timer(150, e -> {
//        updateGUI();
//    });
//
//    private final Deque<DamageThread> damageThreads = new LinkedList<>();
//
//    public void init() {
//        for (int i = 1; i <= 6; i++) {
//            createDamageMonster();
//        }
//        createHealer();
//        healPool.addObserver(this);
//    }
//
//    public void GUITimer() {
//        //Timer timer = new Timer(1000, e -> {
//        //updateGUI();
//        //});
//        timer.start();
//    }
//
//    public void stopTimer() {
//        timer.stop();
//    }
//
//    public void updateGUI() {
//        startView.updateRedLevel(new HealthPoolPanel(healPool.getHealth()), healPool.getHealth());
//    }
//
//    public void createHealer () {
//        Thread thread = new Thread(healThread);
//        thread.start();
//    }
//
//    public void createDamageMonster() {
//
//        Thread thread = new Thread(damageThread);
//        damageThreads.add(damageThread);
//        thread.start();
//    }
//
//    public void terminateThreads() {
//        healThread.stopThread();
//
//        for (DamageThread thread : damageThreads) {
//            thread.stopThread();
//        }
//    }
//
//    @Override
//    public synchronized void update() {
//        int amountOfHealth = this.healPool.getHealth();
//
//        if (amountOfHealth > 170) {
//            terminateThreads();
//            stopTimer();
//            startView.levelComplete();
//        }
//    }
//}
