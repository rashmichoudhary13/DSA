public class StackLL {
    //Stack can be implemented using arraylist or LinkedList

    //Using LinkedList
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Stack{
        Node head = null;

        public boolean isEmpty(){
            return head == null;
        }
        public void push(int data){
            Node newnode = new Node(data);

            if(isEmpty()){
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            return top;
        }
    }


    public static void main(String[] args){
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        if(s.isEmpty()) System.out.println("Empty");
    }
}
