package collections;

import java.util.*;

public class Samples {

    public static void main(String[] args) {
        Iterable<Integer> nums;
        // |
        Collection<Integer> nums2;
        // |
        List<Integer> nums3; // {a,b,c,d}+{a,b,d,x}={a,b,c,d,a,b,d,x}
        Set<Integer> nums4;  // {a,b,c,d}+{a,b,d,x}={a,b,c,d,x}
        Queue<Integer> nums5; //

        lists();
        sets();
        queues();
    }

    static void lists() {

        // List
        List<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(2);
        al.forEach(System.out::println);
        System.out.println("======");

        List<Integer> ll = new LinkedList<>();
        // null <- A <-> B <-> B2 <-> C <-> D <-> D2 <-> E -> null
        ll.add(1);
        ll.add(2);
        ll.forEach(System.out::println);
        System.out.println("======");

        List<Integer> v = new Vector<>();
        v.add(1);
        v.add(2);
        v.forEach(System.out::println);
        System.out.println("======");

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
        s.push(3);
        s.forEach(System.out::println);
        System.out.println("======");
    }

    static void sets() {
        Set<Integer> hs = new HashSet<>();
        hs.add(2);
        hs.add(1);
        hs.add(2);
        hs.forEach(System.out::println);
        System.out.println("======");

        Set<Integer> lhs = new LinkedHashSet<>();
        lhs.add(2);
        lhs.add(1);
        lhs.add(2);
        lhs.forEach(System.out::println);
        System.out.println("======");

        SortedSet<String> ts = new TreeSet<>();
        ts.add("zfv");
        ts.add("abc");
        ts.add("cde");
        ts.add("aab");
        ts.add("bcd");
        ts.forEach(System.out::println);
        System.out.println("======");
    }

    static void queues() {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        System.out.println("======");

        Deque<Integer> ad = new ArrayDeque<>();
        ad.add(1);
        ad.add(2);
        while (!ad.isEmpty()) {
            System.out.println(ad.poll());
        }
        System.out.println("======");
    }
}
