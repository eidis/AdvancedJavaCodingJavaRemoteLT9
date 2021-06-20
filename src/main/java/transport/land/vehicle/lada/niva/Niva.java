package transport.land.vehicle.lada.niva;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.vehicle.lada.Lada;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Niva extends Lada {

    public Niva(Engine engine, Body body, Integer year, Transmission transmission) {
        super(engine, body, year, transmission);
    }

}
