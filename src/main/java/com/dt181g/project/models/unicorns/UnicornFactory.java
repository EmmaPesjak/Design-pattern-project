package com.dt181g.project.models.unicorns;

import com.dt181g.project.models.CharacterFactory;
import com.dt181g.project.support.Constants;

import java.util.Random;

/**
 *
 * @author Emma Pesjak
 */
public class UnicornFactory implements CharacterFactory<BaseUnicorn> {

    // skapa dessa på annat sätt? användaren väljer?

    /**
     *
     * @return
     */
    @Override
    public BaseUnicorn createChar() {
        int randomNmb = new Random().nextInt(Constants.AMOUNT_OF_UNICORNS) + 1;

        if (randomNmb == 1) {
            return new Angrycorn();
        } else if (randomNmb == 2) {
            return new Fancycorn();
        } else if (randomNmb == 3) {
            return new Glamcorn();
        } else if (randomNmb == 4) {
            return new Happycorn();
        } else if (randomNmb == 5) {
            return new Kittycorn();
        } else if (randomNmb == 6) {
            return new Rainbowcorn();
        } else {
            return new Sleepycorn();
        }
    }
}
