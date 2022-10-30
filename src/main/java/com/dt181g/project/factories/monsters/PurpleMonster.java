package com.dt181g.project.factories.monsters;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class PurpleMonster extends BaseCharacter {

    /**
     * Constructor for initializing PurpleMonsters, sets the name and image file path..
     */
    public PurpleMonster() {
        setName(Constants.NAME_PURPLE_MONSTER);
        setImg(Constants.IMAGE_PURPLE_MONSTER);
    }
}
