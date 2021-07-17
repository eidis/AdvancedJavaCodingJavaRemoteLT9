import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/***
 *
 * @author Ignas Ivoska
 *
 */
class FoodTest {

    @Test
    void someTest() {
        assertThrows(NullPointerException.class, () -> {
            String something = null;

            something.startsWith("blablabla");
        });
    }
}