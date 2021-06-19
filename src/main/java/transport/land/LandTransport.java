package transport.land;

import transport.Transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class LandTransport extends Transport {

    private final int numberOfWheels;

    public LandTransport(String engine, String fuel, int numberOfWheels) {
        super(engine, fuel);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

}
