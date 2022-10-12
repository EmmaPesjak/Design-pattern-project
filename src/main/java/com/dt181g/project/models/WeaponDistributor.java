package com.dt181g.project.models;

import java.util.Deque;
import java.util.LinkedList;

//object pool
/**
 *
 * @author Emma Pesjak
 */
public class WeaponDistributor {

    public static final WeaponDistributor INSTANCE = new WeaponDistributor();
    private final Deque<DragonWeapon> weapons = new LinkedList<>();

    /**
     *
     */
    private WeaponDistributor() {
        for (int i = 1; i <= 3; i++) {
            weapons.add(new DragonWeapon(i));
        }
    }

    /**
     *
     * @return
     */
    public synchronized DragonWeapon borrowWeapon() {
        if (!weapons.isEmpty()) {
            return weapons.pollLast();
        } else {
            return null;
        }
    }

    /**
     *
     * @param dragonWeapon
     */
    public synchronized void returnWeapon(DragonWeapon dragonWeapon) {
        weapons.add(dragonWeapon);
    }
}
