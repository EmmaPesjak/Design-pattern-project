package com.dt181g.project.models.threads;

import com.dt181g.project.models.Vaelarya;
import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 * Thread class representing the player healing (producer) in the game.
 * @author Emma Pesjak
 */
public class HealThread implements Runnable {

    private volatile boolean terminate = false; // Boolean that controls the lifetime of the thread.
    private final Vaelarya vaelarya;

    /**
     * Constructor that sets the Vaelarya (dragon) which is the object being healed.
     */
    public HealThread (Vaelarya vaelarya) {
        this.vaelarya = vaelarya;
    }

    /**
     * Overridden method that simulates healing in the game.
     */
    @Override
    public void run() {
        while (!terminate) {
            try {
                vaelarya.addHealth(new Random().nextInt(Constants.MAX_HEALING_AMOUNT) + 1);
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
