package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class RedMonster extends BaseMonster {

    /**
     *
     */
    public RedMonster() {
        setName("Razorteeth");
        setMonsterImg(Constants.IMAGE_RED_MONSTER);
    }
}
