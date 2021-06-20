package transport.land;

import power.Engine;
import transport.CanDrive;
import transport.Transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class LandTransport extends Transport implements CanDrive {

    private final int numberOfWheels;

    public LandTransport(Engine engine, int numberOfWheels) {
        super(engine);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

}
