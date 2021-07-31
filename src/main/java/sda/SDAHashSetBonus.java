package sda;

public class SDAHashSetBonus<E> {

    private static class Obj<T> {

        private T value;
        private Obj<T> next;

        public Obj(T value) {
            this.value = value;
        }
    }

    private Obj<E> value = null;

    public int size() {
        return 1;
    }

    public boolean contains(E o) {
        Obj<E> curObj = value;
        do {
            if (o.equals(curObj.value)) {
                return true;
            }
            curObj = curObj.next;
        } while (curObj != null);
        return false;
    }

    public boolean add(E e) {
        if (value == null) {
            value = new Obj<>(e);
            return true;
        } else {
            if (contains(e)) {
                return false;
            }
            Obj<E> curObj = value;
            while (curObj.next != null) {
                curObj = curObj.next;
            }
            curObj.next = new Obj<>(e);
        }
        return false;
    }

    public boolean remove(Object o) {
        Obj<E> curObj = value;
        do {
            if (o.equals(curObj.value)) {
                curObj.value = curObj.next.value;
                curObj.next = curObj.next.next;
                return true;
            }
            curObj = curObj.next;
        } while (curObj != null);
        return false;
    }

    public void clear() {
        value = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Obj<E> nextObj = value;
        while (nextObj != null) {
            sb.append(nextObj.value);
            nextObj = nextObj.next;
            if (nextObj != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SDAHashSetBonus<String> set = new SDAHashSetBonus<>();
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
