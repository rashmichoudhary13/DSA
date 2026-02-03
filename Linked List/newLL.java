public class newLL {

    Node head;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data){
        Node newnode = new Node(data);

        if(head == null){
            head = newnode;
            return;
        }

        newnode.next = head;
        head = newnode;
    }

    void addLast(int data){
        Node newnode = new Node(data);

        if(head == null){
           head = newnode;
           return;
        }

        Node lastnode = head;
        while(lastnode.next != null){
            lastnode = lastnode.next;
        }

        lastnode.next = newnode;
    }

    void print(){

        if(head == null){
          System.out.print("Linked list is empty");
          return;
        }

        Node lastnode = head;
        while(lastnode != null){
            System.out.print(lastnode.data + "-->");
            lastnode = lastnode.next;
        }
        System.out.println("NULL");
    }

    void removeFirst(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
    }

    void removeLast(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node currnode = head;
        while(currnode.next.next != null){
            currnode = currnode.next;
        }

        currnode.next = null;
    }

    public static void main(String args[]){
        newLL list = new newLL();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.print();
        list.removeFirst();
        list.print();
        list.removeLast();
        list.print();
    }


}
