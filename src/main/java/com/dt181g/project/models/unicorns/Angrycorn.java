package com.dt181g.project.models.unicorns;

import com.dt181g.project.support.Constants;

/**
 * Concrete unicorn of {@link com.dt181g.project.models.unicorns.BaseUnicorn}.
 * @author Emma Pesjak
 */
public class Angrycorn extends BaseUnicorn{

    /**
     * Constructor for initializing Angrycorns, sets the ImageIcon.
     */
    public Angrycorn(){
        setUnicornImg(Constants.IMAGE_ANGRYCORN);
    }
}
