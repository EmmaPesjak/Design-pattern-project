package com.dt181g.project.models.factories;

import com.dt181g.project.models.factories.colors.ColorUnicornBlue;
import com.dt181g.project.models.factories.colors.ColorUnicornRed;
import com.dt181g.project.models.factories.unicorns.*;
import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 * Factory for producing random unicorn characters and colors in the game.
 * @author Emma Pesjak
 */
public class UnicornFactory implements AbstractFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseCharacter createChar() {
        int randomNmb = new Random().nextInt(Constants.AMOUNT_OF_UNICORNS) + 1;

        if (randomNmb == 1) {
            return new Angrycorn();
        } else if (randomNmb == 2) {
            return new Fancycorn();
        } else if (randomNmb == 3) {
            return new Glamcorn();
        } else if (randomNmb == 4) {
            return new Happycorn();
        } else if (randomNmb == 5) {
            return new Kittycorn();
        } else if (randomNmb == 6) {
            return new Rainbowcorn();
        } else {
            return new Sleepycorn();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseColor createColor() {
        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            return new ColorUnicornRed();
        } else {
            return new ColorUnicornBlue();
        }
    }
}
