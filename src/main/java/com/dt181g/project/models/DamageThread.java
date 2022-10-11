package com.dt181g.project.models;

import java.util.Random;

//consumer
public class DamageThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;



    @Override
    public void run() {

        WeaponDistributor distributor = WeaponDistributor.INSTANCE;
        while (!terminate) {

            //ta bort de dubbla try/catch
            if (distributor.hasAnotherWeapon()) {
                try {

                    DragonWeapon weapon = distributor.borrowWeapon();
                    System.out.println(Thread.currentThread().getName() + " is using " + weapon);
                    //här får jag ju fixa något bra random
                    HealthMeter.INSTANCE.removeHealth(new Random().nextInt(20) + 1);  //ta bound 3
                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);

                    System.out.println(Thread.currentThread().getName() + " is returning " + weapon);
                    distributor.returnWeapon(weapon);

                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {

                //UTAN DETTA BLIR DET NULLMÖG
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
