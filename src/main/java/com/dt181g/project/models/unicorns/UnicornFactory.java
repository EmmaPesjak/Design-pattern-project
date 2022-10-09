package com.dt181g.project.models.unicorns;

import com.dt181g.project.models.AbstractFactory;

public class UnicornFactory implements AbstractFactory {


    // skapa dessa på annat sätt? användaren väljer?
    public BaseUnicorn createUnicorn(int randomNmb) {

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
