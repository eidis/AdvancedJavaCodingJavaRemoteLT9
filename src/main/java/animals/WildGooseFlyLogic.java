package animals;

public class WildGooseFlyLogic implements CanFly {

    private final int speed;

    private int distance = 0;

    public WildGooseFlyLogic(int speed) {
        this.speed = speed;
    }

    @Override
    public void fly() {
        distance += speed;
        System.out.println("I'm flying! [" + distance + "km]");
    }

    public int getDistance() {
        return distance;
    }
}
