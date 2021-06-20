package transport.land.vehicle.audi;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Audi extends Vehicle {

    private final String model;

    public Audi(Engine engine, Body body, Integer year,
                Transmission transmission, String model) {
        super(engine, body, year, transmission, "Audi");
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    // Enumerations, Interfaces, Abstract classes, Generics
    // Optional klase

}
