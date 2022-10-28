package com.dt181g.project.models.factories.monsters;

import com.dt181g.project.models.factories.BaseCharacter;
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
        setName("Dorranoth");
        setImg(Constants.IMAGE_GREY_MONSTER);
    }
}
