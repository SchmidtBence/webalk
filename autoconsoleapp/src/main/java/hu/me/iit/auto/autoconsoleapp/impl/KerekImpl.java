package hu.me.iit.auto.autoconsoleapp.impl;


import hu.me.iit.auto.autoconsoleapp.Kerekek;

public class KerekImpl implements Kerekek {
    private final int szelesseg;
    private final int atmero;
    private final int kopenyMagassag;

    public KerekImpl(int szelesseg, int atmero,int kopenyMagassag) {
        this.szelesseg = szelesseg;
        this.atmero = atmero;
        this.kopenyMagassag=kopenyMagassag;
    }

    @Override
    public String toString() {
        return "KerekImpl{" +
                 szelesseg +
                "/" + kopenyMagassag +
                "R " + atmero +
                '}';
    }
}
