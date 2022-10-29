package com.dt181g.project.models.factories.unicorns;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Kittycorn extends BaseCharacter {

    /**
     * Constructor for initializing Kittycorns, sets the name and image file path.
     */
    public Kittycorn() {
        setName(Constants.NAME_KITTYCORN);
        setImg(Constants.IMAGE_KITTYCORN);
    }
}
