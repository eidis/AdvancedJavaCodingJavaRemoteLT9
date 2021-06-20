package transport.land.vehicle;

import power.Engine;
import transport.Body;
import transport.Transmission;
import transport.land.LandTransport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Vehicle extends LandTransport {

    private final String manufacturer;
    private final Body body;
    private final int year;
    private final Transmission transmission;

    public Vehicle(Engine engine, Body body, int year,
                   Transmission transmission, String manufacturer) {
        super(engine, 4);
        this.body = body;
        this.year = year;
        this.transmission = transmission;
        this.manufacturer = manufacturer;
    }

    public Body getBody() {
        return body;
    }

    public Integer getYear() {
        return year;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
