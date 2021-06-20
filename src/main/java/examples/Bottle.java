package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Bottle<T extends Liquid> extends LiquidContainer {

    private final T liquid;
    private boolean isOpen = false;

    public Bottle(T liquid) {
        this.liquid = liquid;
    }

    @Override
    public T get() {
        if (!isOpen) {
            throw new UnsupportedOperationException("Bottle is not opened");
        }
        return liquid;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

}
