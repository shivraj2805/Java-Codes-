import java.util.*;

public class deque {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(1); // 1
        dq.addFirst(2); // 2 1
        dq.addLast(3); // 2 1 3
        dq.addLast(4); // 2 1 3 4

        System.out.println(dq);

        dq.removeLast();
        System.out.println(dq);

        dq.removeFirst();
        System.out.println(dq);

        System.out.println("First Element is : " + dq.getFirst());
        System.out.println("Last Element is : " + dq.getLast());
    }
}
