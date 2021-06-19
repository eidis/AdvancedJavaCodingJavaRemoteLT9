package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class BeerCan extends Food {

    private final int maxMillilitres;
    private int remainingMillilitres;

    public BeerCan(String name) {
        super(name);
        this.remainingMillilitres = 473;
        this.maxMillilitres = remainingMillilitres;
    }

    public BeerCan(String name, int maxMillilitres) {
        super(name);
        this.remainingMillilitres = maxMillilitres;
        this.maxMillilitres = maxMillilitres;
    }

    public boolean isFull() {
        return remainingMillilitres == maxMillilitres;
    }

    public int getRemainingMillilitres() {
        return remainingMillilitres;
    }

    public void drink(int millilitres) {
        if (canDrink(millilitres)) {
            this.remainingMillilitres -= millilitres;
        } else {
            throw new CannotDrinkException();
        }
    }

    private boolean canDrink(int millilitres) {
        return remainingMillilitres > 0 && millilitres <= remainingMillilitres;
    }

    @Override
    public String getName() {
        return "A nice pint of " + super.getName();
    }

}
