package com.dt181g.project.models;

import java.util.Deque;
import java.util.LinkedList;

//object pool
public class WeaponDistributor {

    public static final WeaponDistributor INSTANCE = new WeaponDistributor();
    private final Deque<DragonWeapon> weapons = new LinkedList<>();

    private WeaponDistributor() {
        for (int i = 1; i <= 3; i++) {
            weapons.add(new DragonWeapon(i));
        }
    }

    public DragonWeapon getWeapon() {
        return weapons.pollLast();
    }

    public void returnWeapon(DragonWeapon dragonWeapon) {
        weapons.add(dragonWeapon);
    }

    public boolean hasAnotherWeapon() { return !weapons.isEmpty(); }
}
