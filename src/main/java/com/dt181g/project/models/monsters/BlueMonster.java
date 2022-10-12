package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class BlueMonster extends BaseMonster {

    /**
     *
     */
    public BlueMonster() {
        setName("Blightstrike");
        setMonsterImg(Constants.IMAGE_BLUE_MONSTER);
    }
}
