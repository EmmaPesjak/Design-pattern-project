package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class OrangeMonster extends BaseMonster {

    /**
     *
     */
    public OrangeMonster() {
        setName("Thagloth");
        setMonsterImg(Constants.IMAGE_ORANGE_MONSTER);
    }
}
