package com.dt181g.project.models;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Distributor of the three weapons used by monsters to fight the dragon,
 * implemented with the object pool pattern.
 * @author Emma Pesjak
 */
public class WeaponDistributor {

    public static final WeaponDistributor INSTANCE = new WeaponDistributor();
    private final Deque<DragonWeapon> weapons = new LinkedList<>();

    /**
     * Constructor responsible for creating the three available weapons.
     */
    private WeaponDistributor() {
        for (int i = 1; i <= 3; i++) {
            weapons.add(new DragonWeapon());
        }
    }

    /**
     * Method responsible for lending weapons.
     * @return is the weapon that is borrowed, returns null if no weapon is available.
     */
    public synchronized DragonWeapon borrowWeapon() {
        if (!weapons.isEmpty()) {
            return weapons.pollLast();
        } else {
            return null;
        }
    }

    /**
     * Method responsible for enabling return of weapons.
     * @param dragonWeapon is the weapon that is returned.
     */
    public synchronized void returnWeapon(DragonWeapon dragonWeapon) {
        weapons.add(dragonWeapon);
    }
}
