import examples.Beer;
import examples.Bottle;
import examples.Water;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/***
 *
 * @author Ignas Ivoska
 *
 */
class BeerTest {

    @Test
    public void createsCans() {
        Bottle<Beer> bottle = new Bottle<>(new Beer("Heineken"));
        try {
            bottle.get();
            fail("Bottle is not opened exception is expected");
        } catch (UnsupportedOperationException e) {
            assertEquals("Bottle is not opened", e.getMessage());
        }

        Bottle<Water> waterBottle = new Bottle<>(new Water());
        UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class,
                waterBottle::get);
        assertEquals("Bottle is not opened", e.getMessage());
    }
}