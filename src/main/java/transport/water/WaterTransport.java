package transport.water;

import power.Engine;
import transport.CanSwim;
import transport.Transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class WaterTransport extends Transport implements CanSwim {

    public WaterTransport(Engine engine) {
        super(engine);
    }

}
