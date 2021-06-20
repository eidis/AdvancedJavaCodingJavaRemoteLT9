package transport.land.vehicle.volkswagen.bora;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.volkswagen.Volkswagen;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Bora extends Volkswagen {

    public Bora(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission);
    }

}
