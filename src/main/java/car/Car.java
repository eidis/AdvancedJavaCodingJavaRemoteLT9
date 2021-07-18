package car;

public class Car {

    private final Manufacturer manufacturer;
    private final String model;
    private final String engine;
    private final Color color;
    private final int year;
    private final double price;

    public Car(Manufacturer manufacturer, String model, String engine, Color color, int year, double price) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public Color getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer=" + manufacturer +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", color=" + color +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}