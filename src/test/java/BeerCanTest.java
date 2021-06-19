import examples.Banana;
import examples.BeerCan;
import examples.Food;
import org.junit.jupiter.api.Test;

/***
 *
 * @author Ignas Ivoska
 *
 */
class BeerCanTest {

    @Test
    public void createsCans() {
        Food beer = new BeerCan("Heineken");
        Food banana = new Banana();

        tryToDrink((BeerCan) beer, 1);
        tryToDrink((BeerCan) banana, 2);
    }

    private void tryToDrink(BeerCan can, int millis) {
        try {
            can.drink(millis);
            System.out.println("I just drank");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

}