package com.dt181g.project.models;

import java.util.Random;

//consumer
/**
 *
 * @author Emma Pesjak
 */
public class DamageThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;


    /**
     *
     */
    @Override
    public void run() {

        WeaponDistributor distributor = WeaponDistributor.INSTANCE;
        while (!terminate) {

            try {

                DragonWeapon weapon = distributor.borrowWeapon();

                if (weapon != null) {
                    System.out.println(Thread.currentThread().getName() + " is using " + weapon);
                    //här får jag ju fixa något bra random
                    HealthMeter.INSTANCE.removeHealth(new Random().nextInt(20) + 1);  //ta bound 3, 20 om jag vill att hon ska dö
                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);

                    System.out.println(Thread.currentThread().getName() + " is returning " + weapon);
                    distributor.returnWeapon(weapon);

                    //rest time, fighting is exhausting
                    Thread.sleep(5000);
                } else {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is waiting for a weapon");
                }



            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     *
     */
    public void stopThread() {
        terminate = true;
    }
}
