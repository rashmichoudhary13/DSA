// Implementing queue using Linked list
public class QueueLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        boolean isEmpty() {
            return head == null && tail == null;
        }

        void add(int data) {
            Node newnode = new Node(data);
            if (isEmpty()) {
                head = tail = newnode;
                return;
            }

            tail.next = newnode;
            tail = newnode;
        }

        void remove() {
            if (isEmpty()) {
                System.out.print("Queue is Empty");
                return;
            }

            if(head == tail){
                head = tail = null;
                return;
            }

            head = head.next;
        }

        int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = head.data;
            return result;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
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