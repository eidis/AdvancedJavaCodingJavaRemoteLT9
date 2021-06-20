package transport.land.bike;

import power.Engine;
import transport.land.LandTransport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Bike extends LandTransport {

    public Bike(Engine engine) {
        super(engine, 2);
    }

    public Bike(Engine engine, int numberOfWheels) {
        super(engine, numberOfWheels);
    }

}
