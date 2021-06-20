package transport.land.vehicle.lada;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.Vehicle;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Lada extends Vehicle {

    public Lada(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission, "Lada");
    }

}
