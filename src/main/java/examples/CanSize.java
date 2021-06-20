package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public enum CanSize {
    SMALL(200),
    MEDIUM(330),
    PINT(473),
    LARGER(500),
    HUGE(1000);

    private final int millilitres;

    CanSize(int millilitres) {
        this.millilitres = millilitres;
    }

    public int getMillilitres() {
        return millilitres;
    }

}
