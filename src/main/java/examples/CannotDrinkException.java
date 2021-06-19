package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class CannotDrinkException extends RuntimeException {

    CannotDrinkException() {
        super("Can cannot be drank from");
    }

}
