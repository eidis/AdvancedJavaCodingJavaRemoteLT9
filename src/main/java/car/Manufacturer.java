package car;

public class Manufacturer {

    private final String name;
    private final int yearEstablished;

    public Manufacturer(String name, int yearEstablished) {
        this.name = name;
        this.yearEstablished = yearEstablished;
    }

    public String getName() {
        return name;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "name='" + name + '\'' +
                ", yearEstablished=" + yearEstablished +
                '}';
    }
}
