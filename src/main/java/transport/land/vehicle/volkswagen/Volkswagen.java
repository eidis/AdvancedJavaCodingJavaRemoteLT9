package transport.land.vehicle.volkswagen;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Volkswagen extends Vehicle {

    public Volkswagen(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission, "Volkswagen");
    }

}
