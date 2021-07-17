package examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/***
 *
 * @author Ignas Ivoska
 *
 */
class CanSizeTest {

    @Test
    void checkCanSizes() {
        assertEquals(200, CanSize.SMALL.getMillilitres());
        assertEquals(330, CanSize.MEDIUM.getMillilitres());
        assertEquals(473, CanSize.PINT.getMillilitres());
        assertEquals(500, CanSize.LARGER.getMillilitres());
        assertEquals(1000, CanSize.HUGE.getMillilitres());
    }
}
