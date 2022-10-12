package com.dt181g.project.models;

import com.dt181g.project.models.monsters.MonsterFactory;
import com.dt181g.project.models.unicorns.UnicornFactory;

/**
 * Class responsible for providing the game with factories.
 * @author Emma Pesjak
 */
public class FactoryProvider {

    /**
     * Method for getting a factory.
     * @param nmb represents which factory is to be built.
     * @return a new factory.
     */
    public static CharacterFactory getFactory(int nmb) {
        if (nmb == 1) {
            return new MonsterFactory();
        } else {
            return new UnicornFactory();
        }
    }
}
