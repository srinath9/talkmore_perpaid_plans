package models;

import interfaces.IRate;

/**
 * Created by tech on 17/9/17.
 */
public class Amount implements IRate {
    private int perMinCharge; // in paise

    public Amount(int perMinCharge) {
        this.perMinCharge = perMinCharge;
    }

    @Override
    public float getRate() {
        return (float) (perMinCharge * .01);
    }
}
