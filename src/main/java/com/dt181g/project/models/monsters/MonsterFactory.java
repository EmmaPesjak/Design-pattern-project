package com.dt181g.project.models.monsters;

import com.dt181g.project.models.CharacterFactory;
import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 * Factory for producing random monsters in the game.
 * @author Emma Pesjak
 */
public class MonsterFactory implements CharacterFactory<BaseMonster> {

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseMonster createChar() {

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
}
