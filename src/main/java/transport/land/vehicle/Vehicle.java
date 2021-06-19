package transport.land.vehicle;

import transport.land.LandTransport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Vehicle extends LandTransport {

    private final String manufacturer;
    private final String body;
    private final Integer year;
    private final String transmission;

    public Vehicle(String engine, String fuel, String body, Integer year, String transmission,
                   String manufacturer) {
        super(engine, fuel, 4);
        this.body = body;
        this.year = year;
        this.transmission = transmission;
        this.manufacturer = manufacturer;
    }

    public String getBody() {
        return body;
    }

    public Integer getYear() {
        return year;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}
