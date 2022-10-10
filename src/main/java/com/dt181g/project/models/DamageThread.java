package com.dt181g.project.models;

import java.util.Random;

//consumer
public class DamageThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;

    WeaponDistributor distributor = WeaponDistributor.INSTANCE;

    @Override
    public void run() {
        while (!terminate) {

            //ta bort de dubbla try/catch
            if (distributor.hasAnotherWeapon()) {
                try {

                    DragonWeapon weapon = distributor.getWeapon();
                    System.out.println(Thread.currentThread().getName() + " is using " + weapon.toString());
                    //här får jag ju fixa något bra random
                    HealthMeter.INSTANCE.removeHealth(new Random().nextInt(3) + 1);
                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);

                    distributor.returnWeapon(weapon);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep( 1000);
                    System.out.println(Thread.currentThread().getName() + " is waiting for a weapon ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopThread() {
        terminate = true;
    }
}
