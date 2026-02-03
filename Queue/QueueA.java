//Implement Queue using Array

public class QueueA {
    int arr[];
    int size;
    int rear = -1;

    QueueA(int n){
        arr = new int[n];
        this.size = n;
    }

    boolean isEmpty(){
        return rear == -1;
    }

    void add(int data){
        if(rear == size-1){
            System.out.print("Queue is full");
            return;
        }

        rear++;
        arr[rear] = data;
    }

    int remove(){
        if(isEmpty()){
            System.out.print("Queue is empty");
            return -1;
        }

        int front = arr[0];
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return front;
    }

    int peek(){
        int top = arr[0];
        return top;
    }

    public static void main(String args[]){
        QueueA q = new QueueA(5);
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
