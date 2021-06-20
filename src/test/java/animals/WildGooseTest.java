package animals;

import examples.Banana;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author Ignas Ivoska
 *
 */
class WildGooseTest {

    @Test
    void a() {
        List<CanMakeSound> canMakeSounds = new ArrayList<>();
        canMakeSounds.add(new WildGoose());
        canMakeSounds.add(new CarEngine());

        for (CanMakeSound item : canMakeSounds) {
            item.makeSound();
        }
    }

}