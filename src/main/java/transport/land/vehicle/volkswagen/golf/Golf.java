package transport.land.vehicle.volkswagen.golf;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.volkswagen.Volkswagen;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Golf extends Volkswagen {

    public Golf(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission);
    }

}
