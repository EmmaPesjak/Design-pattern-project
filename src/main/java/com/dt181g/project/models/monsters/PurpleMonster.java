package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class PurpleMonster extends BaseMonster {

    /**
     * Constructor for initializing PurpleMonsters, sets the name and ImageIcon.
     */
    public PurpleMonster() {
        setName("Vilespawn");
        setMonsterImg(Constants.IMAGE_PURPLE_MONSTER);
    }
}
