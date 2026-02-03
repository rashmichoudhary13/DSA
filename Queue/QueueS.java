import java.util.*;
// Implement Queue using 2 stack

public class QueueS {

    //Push using 2 Stack
//    static class Queue{
//        Stack<Integer> s1 = new Stack<>();
//        Stack<Integer> s2 = new Stack<>();
//
//        boolean isEmpty(){
//            return s1.isEmpty();
//        }
//
//        void add(int data){
//            while(!isEmpty()){
//                s2.push(s1.pop());
//            }
//
//            s1.push(data);
//
//            while(!s2.isEmpty()){
//                s1.push(s2.pop());
//            }
//        }
//
//        void remove(){
//            if(isEmpty()){
//                System.out.println("Queue is Empty");
//                return;
//            }
//
//            s1.pop();
//        }
//
//        int peek(){
//            if(isEmpty()){
//                System.out.println("Queue is Empty");
//                return -1;
//            }
//
//            return s1.peek();
//        }
//    }

    //Pop using 2 stack
    static class Queue{
       Stack<Integer> s1 = new Stack<>();
       Stack<Integer> s2 = new Stack<>();

       boolean isEmpty(){
           return s1.isEmpty();
       }

       void add(int data){
           s1.push(data);
       }

       void remove(){
           if(isEmpty()){
               System.out.println("Queue is Empty");
               return;
           }

           while(!isEmpty()){
               s2.push(s1.pop());
           }

           s2.pop();

           while(!s2.isEmpty()){
               s1.push(s2.pop());
           }
       }

       int peek(){
           if(isEmpty()){
               System.out.println("Queue is Empty");
               return -1;
           }

           while(!isEmpty()){
               s2.push(s1.pop());
           }

            int result = s2.peek();

           while(!s2.isEmpty()){
               s1.push(s2.pop());
           }

           return result;
       }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
