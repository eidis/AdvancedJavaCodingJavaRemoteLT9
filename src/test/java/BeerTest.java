import examples.*;
import org.junit.jupiter.api.Test;

/***
 *
 * @author Ignas Ivoska
 *
 */
class BeerTest {

    @Test
    public void createsCans() {
        Bottle<Beer> bottle = new Bottle<>(new Beer("Heineken"));
        bottle.get();
        Bottle<Water> waterBottle = new Bottle<>(new Water());
        waterBottle.get();
    }

}