package hu.me.iit.auto.autoconsoleapp;

public class Car {
    private final Motor motor;
    private final Kerekek[] kerek;
    private final String tipus;

    public Car(Motor motor, Kerekek[] kerek, String tipus) {
        this.motor = motor;
        this.kerek = kerek;
        this.tipus = tipus;
    }
    @Override
    public String toString() {
        return "Car [Motor=" + motor.toString() + ", Kerék=" + kerek[0].toString() + ", tipus=" + tipus + "]";
    }

}
