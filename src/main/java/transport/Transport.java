package transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Transport {

    // No engine, engine
    private final String engine;
    // Diesel, petrol, electric
    private final String fuel;

    public Transport(String engine, String fuel) {
        this.engine = engine;
        this.fuel = fuel;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel() {
        return fuel;
    }
}
