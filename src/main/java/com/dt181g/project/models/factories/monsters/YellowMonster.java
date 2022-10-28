package com.dt181g.project.models.factories.monsters;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class YellowMonster extends BaseCharacter {

    /**
     * Constructor for initializing YellowMonsters sets the name and image file path.
     */
    public YellowMonster() {
        setName("Bloopie");
        setImg(Constants.IMAGE_YELLOW_MONSTER);
    }
}
