package com.dt181g.project.factories.monsters;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class BlueMonster extends BaseCharacter {

    /**
     * Constructor for initializing BlueMonsters, sets the name and image file path.
     */
    public BlueMonster() {
        setName(Constants.NAME_BLUE_MONSTER);
        setImg(Constants.IMAGE_BLUE_MONSTER);
    }
}
