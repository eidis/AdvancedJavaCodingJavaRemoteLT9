package examples;

/***
 *
 * @author Ignas Ivoska
 *
 */
public abstract class Food implements Consumable, CanExpire {

    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void consume(int percentage) {
        if (isExpired()) {
            throw new UnsupportedOperationException("Food is expired");
        }

        System.out.println("Consumed " + percentage);
    }

}
