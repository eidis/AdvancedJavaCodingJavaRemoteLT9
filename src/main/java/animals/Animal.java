package animals;

/***
 *
 * @author Ignas Ivoska
 *
 */
public class Animal implements CanMakeSound {

    private final String sound;

    public Animal(String sound) {
        this.sound = sound;
    }

    @Override
    public String getSound() {
        return sound;
    }

}
