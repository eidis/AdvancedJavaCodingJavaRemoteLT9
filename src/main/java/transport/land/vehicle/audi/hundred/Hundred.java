package transport.land.vehicle.audi.hundred;


import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.audi.Audi;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Hundred extends Audi {

    public Hundred(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission, "100");
    }

}
