package com.autocompany;

import com.autocompany.Kerek;
import com.autocompany.Motor;

public class Auto {
    private final Motor motor;
    private final Kerek[] kereks;
    private final String tipus;

    public Auto(Motor motor, Kerek[] kereks,String tipus) {
        this.motor = motor;
        this.kereks = kereks;
        this.tipus=tipus;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "motor=" + motor.toString() +
                ", kerek=" + kereks[0].toString() + "Tipus=" +tipus+
                '}';
    }
}
