package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class GreenMonster extends BaseMonster {

    /**
     *
     */
    public GreenMonster() {
        setName("Ashflayer");
        setMonsterImg(Constants.IMAGE_GREEN_MONSTER);
    }
}
