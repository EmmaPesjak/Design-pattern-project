package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class SlimeMonster extends BaseMonster {

    /**
     *
     */
    public SlimeMonster() {
        setName("Gutscream");
        setMonsterImg(Constants.IMAGE_SLIME_MONSTER);
    }
}
