package com.dt181g.project.models.factories.unicorns;

import com.dt181g.project.models.factories.BaseCharacter;
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
        setName("Sleepy");
        setImg(Constants.IMAGE_SLEEPYCORN);
    }
}
