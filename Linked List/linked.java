public class linked {

    Node head;
    static int size;

    class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
            this.next = null;
        }
    }

    //Add first
    public void addFirst(String data){
         Node newnode = new Node(data);
         size++;
         if(head == null){
             head = newnode;
             return;
         }

         newnode.next = head;
         head = newnode;
    }

    //add Last
    public void addLast(String data){
        Node newnode = new Node(data);
        size++;
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

    //print
    public void Print(){

        if(head == null){
            System.out.print("list is empty");
            return;
        }

        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + "-->");
            currNode = currNode.next;
        }

        System.out.println("NULL");
    }

    //Remove first
    public void removeFirst(){

        if(head == null){
           System.out.print("List is empty");
           return;
        }
        size--;
        head = head.next;

    }

    //Remove Last
    public void removeLast(){

        if(head == null){
            System.out.println("empty list");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node currnode = head;
        Node lastnode = head.next;
        System.out.println("currnode " + currnode.data);
        System.out.println("lastnode " + lastnode.data);

        while(lastnode.next != null){
            lastnode = lastnode.next;
            currnode = currnode.next;
        }

        currnode.next = null;
    }

    //search
    public int searchList(String no){

        if(head==null){
            System.out.println("List is empty");
            return -1;
        }


        int index = 0;
        Node currnode = head;
        while(currnode != null){
            if(currnode.data == no){
               return index;
            }
            index++;
            currnode = currnode.next;
        }
        return -1;
    }

    //Reversed a linked list using Iteration
    public void reversed(){
       Node prevnode = head;
       Node currnode = head.next;

       while(currnode != null){
           Node nextnode = currnode.next;
           currnode.next = prevnode;

           //update all 2
           prevnode = currnode;
           currnode = nextnode;
       }

       head.next = null;
       head = prevnode;
    }

    //Reversed a linked list using Recursion
    public Node reverseRecursive(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    //Remove Nth node from the end of list
    public Node removeNth(Node head, int n){
      if(head == null || head.next == null){
          return null;
      }

      if(n == size){
          return head.next;
      }

      Node prev = head;
      int indexToSearch = size - n;
      for(int i = 1; i < indexToSearch; i++){
          prev = prev.next;
      }
      prev.next = prev.next.next;

      return head;
    }

    public Node findMiddle(Node head){
        Node hare = head;
        Node turtle = head;

        if(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;
        }

        return turtle;
    }

    //Check for palindromic List
    //Approach: 1. Find the middle node 2. Reverse the second half 3.Compare first and second half
    public boolean isListPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node middle = findMiddle(head);
        Node SecondHalfStart = reverseRecursive(middle.next);

        Node FirstHalfStart = head;

        while(SecondHalfStart != null){
            if(FirstHalfStart.data != SecondHalfStart.data){
                return false;
            }
            FirstHalfStart = FirstHalfStart.next;
            SecondHalfStart = SecondHalfStart.next;
        }

        return true;
    }

    //Check if list has a cycle
    public boolean HasCycle(){

        if(head == null){
            return false;
        }

        Node hare = head;
        Node turtle = head;

        while(hare.next != null && hare.next.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare == turtle){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args ){
        linked list = new linked();
        list.addFirst("1");
        list.addLast("5");
        list.addLast("7");
        list.addLast("3");
        list.addLast("8");
        list.addLast("2");
        list.addLast("3");
//        list.Print();
//        System.out.println("Reversed list is: ");
//      list.reversed();
//        list.head = list.reverseRecursive(list.head);
//        list.Print();
//        list.head = list.removeNth(list.head,2);
//        list.Print();

//        int ind = list.searchList("20");
//        if(ind == -1){
//            System.out.println("Element is not present in the list");
//        }else{
//            System.out.println("Element is present at index " + ind);
//        }
//
//        System.out.println("Size is " + size);
//        System.out.println("Head is "+ list.head.data);
//        list.removeFirst();
//        list.Print();
//        list.removeLast();
//        list.Print();
//        System.out.println("Size is " + size);

        linked newlist = new linked();
        newlist.addFirst("m");
        newlist.addLast("a");
        newlist.addLast("d");
        newlist.addLast("a");
        newlist.addLast("m");
        newlist.Print();

        if(newlist.isListPalindrome()){
            System.out.println("The given list is palindrome.");
        }else{
            System.out.println("The given list is not palindrome");
        }



    }
}
