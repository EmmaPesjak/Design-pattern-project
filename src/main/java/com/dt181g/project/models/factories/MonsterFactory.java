package com.dt181g.project.models.factories;

import com.dt181g.project.models.factories.colors.ColorMonsterBlue;
import com.dt181g.project.models.factories.colors.ColorMonsterRed;
import com.dt181g.project.models.factories.monsters.*;
import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 * Factory for producing random monster characters and colors in the game.
 * @author Emma Pesjak
 */
public class MonsterFactory implements AbstractFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseCharacter createChar() {

        int randomNmb = new Random().nextInt(Constants.AMOUNT_OF_MONSTERS) + 1;

        if (randomNmb == 1) {
            return new BlueMonster();
        } else if (randomNmb == 2) {
            return new GreenMonster();
        } else if (randomNmb == 3) {
            return new GreyMonster();
        } else if (randomNmb == 4) {
            return new OrangeMonster();
        } else if (randomNmb == 5) {
            return new PurpleMonster();
        } else if (randomNmb == 6) {
            return new RedMonster();
        } else if (randomNmb == 7) {
            return new SlimeMonster();
        } else {
            return new YellowMonster();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseColor createColor() {
        int randomNmb = new Random().nextInt(2) + 1;

        if (randomNmb == 1) {
            return new ColorMonsterRed();
        } else {
            return new ColorMonsterBlue();
        }
    }
}
