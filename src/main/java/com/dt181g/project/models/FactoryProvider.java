package com.dt181g.project.models;

import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.UnicornFactory;

public class FactoryProvider {

    public static CharacterFactory getFactory(int nmb) {
        if (nmb == 1) {
            return new MonsterFactory();
        } else {
            return new UnicornFactory();
        }
    }


    //kan detta fixas av model??


    //skippa denna??
}
