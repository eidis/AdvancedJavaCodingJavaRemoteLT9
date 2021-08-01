package sda;

import java.util.HashMap;
import java.util.Map;

public class SDAHashSet<E> {

    private final Map<Integer, E> hashtable = new HashMap<>();

    public int size() {
        return hashtable.size();
    }

    public boolean contains(Object o) {
        return hashtable.containsKey(o.hashCode());
    }

    public boolean add(E e) {
        int hash = e.hashCode();
        if (!contains(e)) {
            hashtable.put(hash, e);
            return true;
        }
        return false;
    }

    public boolean remove(Object o) {
        return hashtable.remove(o.hashCode()) != null;
    }

    public void clear() {
        hashtable.clear();
    }

    @Override
    public String toString() {
        return hashtable.toString();
    }

    public static void main(String[] args) {
        SDAHashSet<String> set = new SDAHashSet<>();
        set.add("x");
        set.add("a");
        set.add("a");
        set.add("bb");
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
