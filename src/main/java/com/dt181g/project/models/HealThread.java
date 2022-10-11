package com.dt181g.project.models;


import java.util.Random;

//producer
public class HealThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;

    @Override
    public void run() {
        while (!terminate) {
            try {
                HealthMeter.INSTANCE.addHealth(new Random().nextInt(1) + 1);  //ta bound 20
                Thread.sleep((new Random().nextInt(2) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        terminate = true;
    }
}
