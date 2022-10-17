package com.dt181g.project.models;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Distributor of the three weapons used by monsters to fight the dragon,
 * implemented with the object pool pattern and as a singleton.
 * @author Emma Pesjak
 */
public class WeaponDistributor {

    public static final WeaponDistributor INSTANCE = new WeaponDistributor();
    private final BlockingQueue<Weapon> weapons = new LinkedBlockingQueue<>();

    /**
     * Constructor responsible for creating the three available weapons.
     */
    private WeaponDistributor() {
        for (int i = 1; i <= 3; i++) {
            weapons.add(new Weapon());
        }
    }

    /**
     * Method responsible for lending weapons.
     * @return is the weapon that is borrowed, returns null if no weapon is available.
     */
    public Weapon borrowWeapon() {
        if (!weapons.isEmpty()) {
            return weapons.poll();
        } else {
            return null;
        }
    }

    /**
     * Method responsible for enabling return of weapons.
     * @param weapon is the weapon that is returned.
     */
    public void returnWeapon(Weapon weapon) {
        weapons.add(weapon);
    }
}
