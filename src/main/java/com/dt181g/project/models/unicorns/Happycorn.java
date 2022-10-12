package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Happycorn extends BaseUnicorn{

    /**
     * Constructor for initializing Happycorns, sets the ImageIcon.
     */
    public Happycorn() {
        setUnicornImg(Constants.IMAGE_HAPPYCORN);
    }
}
