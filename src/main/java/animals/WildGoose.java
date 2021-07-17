package animals;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class WildGoose extends Animal implements CanFly, CanSwim {

    private final CanSwim swimLogic = new WildGooseSwimLogic();
    private final WildGooseFlyLogic flyLogic;

    public WildGoose() {
        this(1);
    }

    public WildGoose(int speed) {
        super("Quack");
        this.flyLogic = new WildGooseFlyLogic(speed);
    }

    @Override
    public void fly() {
        flyLogic.fly();
    }

    @Override
    public void swim() {
        swimLogic.swim();
    }

    public int getDistance() {
        return flyLogic.getDistance();
    }
}
