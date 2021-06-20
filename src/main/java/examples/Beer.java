package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Beer extends Food implements Liquid {

    private final int maxMillilitres;
    private int remainingMillilitres;

    public Beer(String name) {
        super(name);
        this.remainingMillilitres = CanSize.PINT.getMillilitres();
        this.maxMillilitres = remainingMillilitres;
    }

    public Beer(String name, CanSize canSize) {
        super(name);
        this.remainingMillilitres = canSize.getMillilitres();
        this.maxMillilitres = canSize.getMillilitres();
    }

    public boolean isFull() {
        return remainingMillilitres == maxMillilitres;
    }

    private boolean canDrink(int millilitres) {
        return remainingMillilitres > 0 && millilitres <= remainingMillilitres;
    }

    private void drink(int millilitres) {
        if (canDrink(millilitres)) {
            this.remainingMillilitres -= millilitres;
        } else {
            throw new CannotDrinkException();
        }
        super.consume(millilitres);
    }

    @Override
    public void consume(int millilitres) {
        drink(millilitres);
    }

}
