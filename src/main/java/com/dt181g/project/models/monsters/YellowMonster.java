package com.dt181g.project.models.monsters;

import com.dt181g.project.support.Constants;

/**
 * Concrete monster of {@link com.dt181g.project.models.monsters.BaseMonster}.
 * @author Emma Pesjak
 */
public class YellowMonster extends BaseMonster {

    /**
     * Constructor for initializing YellowMonsters, sets the name and ImageIcon.
     */
    public YellowMonster() {
        setName("Bloopie");
        setMonsterImg(Constants.IMAGE_YELLOW_MONSTER);
    }
}
