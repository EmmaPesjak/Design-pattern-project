package com.dt181g.project.support;

import java.util.Random;

/**
 * Class representing the weapons used by monsters to fight the dragon.
 * @author Emma Pesjak
 */
public class Weapon {

    /**
     * Method for getting the amount of damage the weapon does.
     * @return the weapon's damage as an integer.
     */
    public int getDamage() {
        return new Random().nextInt(Constants.MAX_WEAPON_DAMAGE) + 1;
    }
}
