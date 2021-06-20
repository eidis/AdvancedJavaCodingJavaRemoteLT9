package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Banana extends Food {

    public Banana() {
        super("Banana");
    }

    @Override
    public void consume(int percentage) {
        System.out.println("Nom");
    }

}
