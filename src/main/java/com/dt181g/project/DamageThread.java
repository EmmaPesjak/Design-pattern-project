package com.dt181g.project;

import java.util.Random;

//consumer
public class DamageThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;

    @Override
    public void run() {
        while (!terminate) {
            try {
                //här får jag ju fixa något bra random
                HealPool.INSTANCE.removeHealth(new Random().nextInt(3) + 1);
                Thread.sleep((new Random().nextInt(10) + 1) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        System.out.println("damagethread stopped");
        terminate = true;
    }
}
