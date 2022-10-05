package com.dt181g.project;

import com.dt181g.project.views.HealthPoolPanel;

import javax.swing.*;
import java.util.Deque;
import java.util.LinkedList;

//public class ObserverThing implements Observer {

    //HealPool healPool;

    //public static final ObserverThing INSTANCE = new ObserverThing(HealPool.INSTANCE);

    //private final HealThread healThread = new HealThread();
    //private final DamageThread damageThread = new DamageThread();

    //Timer timer = new Timer(1000, e -> {

        //updateGUI();
    //});

    //private final Deque<DamageThread> damageThreads = new LinkedList<>();

    //public ObserverThing(HealPool healPool) {
        //this.healPool = healPool;

        //healPool.addObserver(this);

        //init();
        //GUITimer();

   //}

    //public void init() {
        //for (int i = 1; i <= 6; i++) {
            //createDamageMonster();
        //}
        //createHealer();
    //}

    //public void GUITimer() {
        //Timer timer = new Timer(1000, e -> {
            //updateGUI();

        //});
        //timer.start();
    //}

    //public void stopTimer() {
        //timer.stop();
    //}

    //public HealthPoolPanel updateGUI() {
        //System.out.println("updating UI");
        //return (new HealthPoolPanel(healPool.getHealth()));
    //}

    //public void createHealer () {
       // Thread thread = new Thread(healThread);
        //thread.start();
    //}

  //  public void createDamageMonster() {

   //     Thread thread = new Thread(damageThread);
 //       damageThreads.add(damageThread);
 //       thread.start();
 //   }

  //  public void terminateThreads() {
  //      healThread.stopThread();

  //     for (DamageThread thread : damageThreads) {
 //           thread.stopThread();
 //       }
 //   }

 //  // @Override
    //public void update() {
       // int amountOfHealth = this.healPool.getHealth();
   // }
//}
