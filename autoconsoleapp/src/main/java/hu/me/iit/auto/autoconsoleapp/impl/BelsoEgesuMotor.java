package hu.me.iit.auto.autoconsoleapp.impl;

import hu.me.iit.auto.autoconsoleapp.Motor;

public class BelsoEgesuMotor implements Motor {
    private final int loEro;
    private final int ccn;


    public BelsoEgesuMotor(int loEro, int ccn) {
        this.loEro = loEro;
        this.ccn = ccn;
    }

    @Override
    public String toString() {
        return "MotorImpl{" +
                "loEro=" + loEro +
                ", ccn=" + ccn +
                '}';
    }
}
