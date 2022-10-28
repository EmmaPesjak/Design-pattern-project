package com.dt181g.project.models.factories.monsters;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class RedMonster extends BaseCharacter {

    /**
     * Constructor for initializing RedMonsters, sets the name and image file path.
     */
    public RedMonster() {
        setName("Razorteeth");
        setImg(Constants.IMAGE_RED_MONSTER);
    }
}
