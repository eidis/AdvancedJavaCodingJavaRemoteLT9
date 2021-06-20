package transport.air;

import power.Engine;
import transport.CanFly;
import transport.Transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class AirTransport extends Transport implements CanFly {

    public AirTransport(Engine engine) {
        super(engine);
    }

}
