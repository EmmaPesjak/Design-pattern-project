package com.dt181g.project.models.monsters;


import com.dt181g.project.models.CharacterFactory;
import com.dt181g.project.support.Constants;

import java.util.Random;

//bra för att randomiza fram monster på flera ställen i koden...
public class MonsterFactory implements CharacterFactory<BaseMonster> {

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
