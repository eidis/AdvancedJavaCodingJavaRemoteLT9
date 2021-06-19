package transport.land.vehicle.audi;

import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Audi extends Vehicle {

    private final String model;

    public Audi(String engine, String fuel, String body, Integer year,
                String transmission, String model) {
        super(engine, fuel, body, year, transmission, "Audi");
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    // Enumerations, Interfaces, Abstract classes, Generics
    // Optional klase

}
