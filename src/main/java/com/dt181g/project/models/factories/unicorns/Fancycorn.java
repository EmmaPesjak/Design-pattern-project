package com.dt181g.project.models.factories.unicorns;

import com.dt181g.project.models.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Fancycorn extends BaseCharacter {

    /**
     * Constructor for initializing Fancycorns, sets the name and image file path.
     */
    public Fancycorn() {
        setName("Fancy");
        setImg(Constants.IMAGE_FANCYCORN);
    }
}