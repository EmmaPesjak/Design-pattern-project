package com.dt181g.project.models.factories.monsters;

import com.dt181g.project.models.factories.BaseCharacter;
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
        setName("Vilespawn");
        setImg(Constants.IMAGE_PURPLE_MONSTER);
    }
}