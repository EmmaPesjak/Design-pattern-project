package com.dt181g.project.factories.unicorns;

import com.dt181g.project.factories.BaseCharacter;
import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link BaseCharacter}.
 * @author Emma Pesjak
 */
public class Happycorn extends BaseCharacter {

    /**
     * Constructor for initializing Happycorns, sets the name and image file path.
     */
    public Happycorn() {
        setName(Constants.NAME_HAPPYCORN);
        setImg(Constants.IMAGE_HAPPYCORN);
    }
}
