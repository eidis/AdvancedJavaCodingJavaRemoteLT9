package transport.land.bike;

import transport.land.LandTransport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Bike extends LandTransport {

    public Bike(String engine, String fuel) {
        super(engine, fuel, 2);
    }

    public Bike(String engine, String fuel, int numberOfWheels) {
        super(engine, fuel, numberOfWheels);
    }

}
