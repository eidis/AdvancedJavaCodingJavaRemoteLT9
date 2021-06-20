package power;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface Powered<T> {

    T getFuel();

    boolean hasPower();

    void work();

    void fill(T fuel, int amount);

}
