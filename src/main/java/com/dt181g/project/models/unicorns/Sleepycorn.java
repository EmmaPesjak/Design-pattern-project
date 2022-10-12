package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Sleepycorn extends BaseUnicorn {

    /**
     * Constructor for initializing Sleepycorns, sets the ImageIcon.
     */
    public Sleepycorn() {
        setUnicornImg(Constants.IMAGE_SLEEPYCORN);
    }
}
