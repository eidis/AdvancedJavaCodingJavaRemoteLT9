package power;

import transport.Fuel;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Engine implements Powered<Fuel> {

    private final Fuel fuel;
    private int fuelAmount = 0;

    public Engine(Fuel fuel) {
        this.fuel = fuel;
    }

    @Override
    public Fuel getFuel() {
        return fuel;
    }

    @Override
    public boolean hasPower() {
        return fuelAmount > 0;
    }

    @Override
    public void work() {
        fuelAmount--;
        System.out.println("Wrrrrrr");
    }

    @Override
    public void fill(Fuel fuel, int amount) {
        if (this.fuel != fuel) {
            throw new UnsupportedOperationException("Cannot refill this engine with this type of fuel");
        }
        fuelAmount += amount;
    }

}
