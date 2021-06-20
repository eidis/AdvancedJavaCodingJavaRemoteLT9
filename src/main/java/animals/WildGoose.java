package animals;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class WildGoose extends Animal implements CanFly, CanSwim {

    public WildGoose() {
        super("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }

    @Override
    public void swim() {
        System.out.println("I am swimming!");
    }
}
