import java.util.*;

// Implementing queue using Collection Framework
// Queue is an interface so it can be implemented using
//either LinkedList or ArrayDeque class
public class QueueCF {

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

        System.out.println(q.isEmpty());
    }
}
