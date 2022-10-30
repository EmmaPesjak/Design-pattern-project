package com.dt181g.project.factories.monsters;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class OrangeMonster extends BaseCharacter {

    /**
     * Constructor for initializing OrangeMonsters, sets the name and image file path..
     */
    public OrangeMonster() {
        setName(Constants.NAME_ORANGE_MONSTER);
        setImg(Constants.IMAGE_ORANGE_MONSTER);
    }
}
