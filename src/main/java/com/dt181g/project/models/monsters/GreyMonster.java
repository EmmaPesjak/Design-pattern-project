package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class GreyMonster extends BaseMonster {

    /**
     * Constructor for initializing GreyMonsters, sets the name and ImageIcon.
     */
    public GreyMonster() {
        setName("Dorranoth");
        setMonsterImg(Constants.IMAGE_GREY_MONSTER);
    }
}
