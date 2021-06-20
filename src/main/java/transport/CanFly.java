package transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface CanFly extends Movable {

    default void fly(int meters) {
        move(meters);
    }

}
