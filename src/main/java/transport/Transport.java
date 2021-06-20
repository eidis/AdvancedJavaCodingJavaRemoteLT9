package transport;

import power.Engine;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Transport implements Movable {

    private final Engine engine;
    private int movedDistance = 0;

    public Transport(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public void move(int meters) {
        movedDistance += meters;
    }

    @Override
    public int getTotalMetersMoved() {
        return movedDistance;
    }

}
