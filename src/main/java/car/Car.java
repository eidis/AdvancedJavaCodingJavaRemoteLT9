package car;

public class Car {

    private final String engine;
    private final String color;
    private final int year;

    public Car(String engine, String color, int year) {
        this.engine = engine;
        this.color = color;
        this.year = year;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                '}';
    }
}