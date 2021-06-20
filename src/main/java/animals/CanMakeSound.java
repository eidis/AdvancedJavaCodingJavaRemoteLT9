package animals;

/***
 *
 * @author Ignas Ivoska
 *
 */
public interface CanMakeSound {

    String getSound();

    default void makeSound() {
        System.out.println(getSound());
    }

}
