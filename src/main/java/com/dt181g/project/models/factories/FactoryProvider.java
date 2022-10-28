package com.dt181g.project.models.factories;

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
    public static AbstractFactory getFactory(int nmb) {
        if (nmb == 1) {
            return new MonsterFactory();
        } else {
            return new UnicornFactory();
        }
    }
}
