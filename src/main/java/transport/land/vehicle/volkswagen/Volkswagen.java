package transport.land.vehicle.volkswagen;

import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Volkswagen extends Vehicle {

    public Volkswagen(String engine, String fuel, String body, Integer year,
                      String transmission) {
        super(engine, fuel, body, year, transmission, "Volkswagen");
    }

}
