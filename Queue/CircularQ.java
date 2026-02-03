//Implementing Circular queue using array

public class CircularQ {

    static class Queue{
        int arr[];
        int size;
        int rear = -1;
        int front = -1;

        Queue(int n){
            arr = new int[n];
            this.size = n;
        }

        boolean isEmpty(){
            return rear == -1 && front == -1;
        }
        
        boolean isFull(){
            return (rear+1)%size == front;
        }
        //Enqueue
        void add(int data){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(front == -1){
                front++;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        //Dequeue
        void remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return;
            }

            int result = arr[front];
            if(rear == front){
                rear = front = -1;
            }else{
                front = (front+1)%size;
            }
        }

        int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }

            int result = arr[front];
            return result;
        }
    }

    public static void main(String args[]){
        Queue cq = new Queue(4);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);

        while(!cq.isEmpty()){
            System.out.println(cq.peek());
            cq.remove();
        }

        System.out.println(cq.isEmpty());
    }

}
