package com.dt181g.project.factories.monsters;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class GreyMonster extends BaseCharacter {

    /**
     * Constructor for initializing GreyMonsters, sets the name and image file path..
     */
    public GreyMonster() {
        setName(Constants.NAME_GREY_MONSTER);
        setImg(Constants.IMAGE_GREY_MONSTER);
    }
}
