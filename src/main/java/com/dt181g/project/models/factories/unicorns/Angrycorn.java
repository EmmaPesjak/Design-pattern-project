package com.dt181g.project.models.factories.unicorns;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Angrycorn extends BaseCharacter {

    /**
     * Constructor for initializing Angrycorns, sets the name and image file path.
     */
    public Angrycorn(){
        setName(Constants.NAME_ANGRYCORN);
        setImg(Constants.IMAGE_ANGRYCORN);
    }
}
