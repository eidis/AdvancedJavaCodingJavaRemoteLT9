package transport;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface CanDrive extends Movable {

    int getNumberOfWheels();

    default void drive(int meters) {
        move(meters);
    }

}
