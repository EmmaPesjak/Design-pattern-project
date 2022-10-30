package com.dt181g.project.factories.unicorns;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Glamcorn extends BaseCharacter {

    /**
     * Constructor for initializing Glamcorns, sets the name and image file path.
     */
    public Glamcorn() {
        setName(Constants.NAME_GLAMCORN);
        setImg(Constants.IMAGE_GLAMCORN);
    }
}
