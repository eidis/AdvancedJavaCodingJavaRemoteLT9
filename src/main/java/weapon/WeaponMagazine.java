package weapon;

import java.util.Stack;

public class WeaponMagazine {

    private final Stack<String> bullets = new Stack<>();
    private final int magazineSize;

    public WeaponMagazine(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    public void loadBullet(String bullet) {
        if (bullets.size() >= magazineSize) {
            throw new WeaponMagazineException("Magazine exceeds capacity of " + magazineSize);
        }
        bullets.add(bullet);
    }

    public boolean isLoaded() {
        return !bullets.isEmpty();
    }

    public void shot() {
        if (isLoaded()) {
            System.out.println(bullets.pop());
        }
        if (!isLoaded()) {
            System.out.println("empty magazine");
        }
    }

    public static void main(String[] args) {
        WeaponMagazine wp = new WeaponMagazine(2);
        System.out.println(wp.isLoaded());

        wp.loadBullet("asd");
        wp.loadBullet("def");
        System.out.println(wp.isLoaded());

        wp.shot();
        wp.shot();
        wp.shot();
    }
}