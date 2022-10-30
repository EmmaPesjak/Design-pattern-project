package com.dt181g.project.factories.monsters;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class SlimeMonster extends BaseCharacter {

    /**
     * Constructor for initializing SlimeMonsters, sets the name and image file path..
     */
    public SlimeMonster() {
        setName(Constants.NAME_SLIME_MONSTER);
        setImg(Constants.IMAGE_SLIME_MONSTER);
    }
}
