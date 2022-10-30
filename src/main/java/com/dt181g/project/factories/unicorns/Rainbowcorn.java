package com.dt181g.project.factories.unicorns;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Rainbowcorn extends BaseCharacter {

    /**
     * Constructor for initializing Rainbowcorns, sets the name and image file path.
     */
    public Rainbowcorn() {
        setName(Constants.NAME_RAINBOWCORN);
        setImg(Constants.IMAGE_RAINBOWCORN);
    }

}
