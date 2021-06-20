package transport.air.plane;

import power.Engine;
import transport.CanDrive;
import transport.air.AirTransport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Plane extends AirTransport implements CanDrive {

    private final int numberOfWheels;

    public Plane(Engine engine, int numberOfWheels) {
        super(engine);
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void fly(int meters) {
        drive(100);
        super.fly(meters);
        drive(100);
    }

}
