package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Fancycorn extends BaseUnicorn {

    /**
     * Constructor for initializing Fancycorns, sets the ImageIcon.
     */
    public Fancycorn() {
        setUnicornImg(Constants.IMAGE_FANCYCORN);
    }
}
