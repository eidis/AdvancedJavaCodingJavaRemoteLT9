package transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface CanSwim extends Movable {

    default void swim(int meters) {
        move(meters);
    }

}
