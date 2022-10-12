package com.dt181g.project.models;

import java.util.Random;

/**
 * Thread class representing damaging monsters (consumer) in the game.
 * @author Emma Pesjak
 */
public class DamageThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;

    /**
     * Overridden method that simulates damaging in the game.
     */
    @Override
    public void run() {

        WeaponDistributor distributor = WeaponDistributor.INSTANCE;
        while (!terminate) {
            try {
                // Try to borrow a weapon from the distributor.
                DragonWeapon weapon = distributor.borrowWeapon();
                if (weapon != null) {
                    // If a weapon is available, sleep representing the time it takes to swing the weapon.
                    Thread.sleep((new Random().nextInt(10) + 1) * 1000);
                    // Remove health from the health meter.
                    Vaelarya.INSTANCE.removeHealth(new Random().nextInt(3) + 1);
                    // Return the weapon.
                    distributor.returnWeapon(weapon);
                    // Sleep representing rest time, fighting is exhausting.
                    Thread.sleep(5000);
                } else {
                    /* If no weapon is available, sleep representing idle waiting for another weapon,
                    monsters can't focus all the time. */
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that will make the DamageThread terminate.
     */
    public void stopThread() {
        terminate = true;
    }
}
