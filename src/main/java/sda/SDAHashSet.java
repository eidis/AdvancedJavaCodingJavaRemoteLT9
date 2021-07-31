package sda;

import java.util.ArrayList;
import java.util.List;

public class SDAHashSet<E> {

    private final List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public boolean add(E e) {
        if (!contains(e)) {
            return list.add(e);
        }
        return false;
    }

    public boolean remove(Object o) {
        return list.remove(o);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        SDAHashSet<String> set = new SDAHashSet<>();
        set.add("a");
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println(set);
        set.remove("a");
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(set.contains("a") + "/" + set.contains("b"));
        set.clear();
        System.out.println(set);
        System.out.println(set.size());
    }
}
