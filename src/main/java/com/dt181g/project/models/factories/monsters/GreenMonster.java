package com.dt181g.project.models.factories.monsters;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class GreenMonster extends BaseCharacter {

    /**
     * Constructor for initializing GreenMonsters, sets the name and image file path.
     */
    public GreenMonster() {
        setName("Ashflayer");
        setImg(Constants.IMAGE_GREEN_MONSTER);
    }
}
