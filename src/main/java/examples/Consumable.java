package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface Consumable {

    default void consume(int percentage) {
        System.out.println("Nom " + percentage);
    }

}
