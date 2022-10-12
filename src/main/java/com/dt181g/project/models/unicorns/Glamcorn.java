package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Glamcorn extends BaseUnicorn{

    /**
     * Constructor for initializing Glamcorns, sets the ImageIcon.
     */
    public Glamcorn() {
        setUnicornImg(Constants.IMAGE_GLAMCORN);
    }
}
