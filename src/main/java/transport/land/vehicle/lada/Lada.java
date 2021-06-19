package transport.land.vehicle.lada;

import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Lada extends Vehicle {

    public Lada(String engine, String fuel, String body, Integer year,
                String transmission) {
        super(engine, fuel, body, year, transmission, "Lada");
    }

}
