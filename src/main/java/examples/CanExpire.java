package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface CanExpire {

    default boolean isExpired() {
        return false;
    }

}
