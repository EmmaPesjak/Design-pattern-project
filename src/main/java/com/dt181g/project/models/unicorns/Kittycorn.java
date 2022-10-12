package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Kittycorn extends BaseUnicorn {

    /**
     * Constructor for initializing Kittycorns, sets the ImageIcon.
     */
    public Kittycorn() {
        setUnicornImg(Constants.IMAGE_KITTYCORN);
    }
}
