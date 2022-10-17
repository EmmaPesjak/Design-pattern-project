package com.dt181g.project.models;

import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 * Thread class representing the player healing (producer) in the game.
 * @author Emma Pesjak
 */
public class HealThread implements Runnable {

    // Boolean that controls the lifetime of the thread.
    private volatile boolean terminate = false;

    /**
     * Overridden method that simulates healing in the game.
     */
    @Override
    public void run() {
        while (!terminate) {
            try {
                Vaelarya.INSTANCE.addHealth(new Random().nextInt(Constants.HEALING_AMOUNT) + 1);
                Thread.sleep(Constants.SLEEP_HEAL * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that will make the HealThread terminate.
     */
    public void stopThread() {
        terminate = true;
    }
}
