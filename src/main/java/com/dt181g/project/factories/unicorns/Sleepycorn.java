package com.dt181g.project.factories.unicorns;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Sleepycorn extends BaseCharacter {

    /**
     * Constructor for initializing Sleepycorns, sets the name and image file path.
     */
    public Sleepycorn() {
        setName(Constants.NAME_SLEEPYCORN);
        setImg(Constants.IMAGE_SLEEPYCORN);
    }
}
