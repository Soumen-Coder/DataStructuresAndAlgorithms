package StacksAndQueues;

public class CircularQueue {

    protected int[] data;
    protected int size = 0;
    protected int front = 0;
    protected int end = 0;

    private static final int DEFAULT_SIZE = 10;

    CircularQueue(){
        this(DEFAULT_SIZE);
    }

    CircularQueue(int size){
        data = new int[size];
    }

    public boolean insert(int item) throws CircularQueueException{
        if(isFull()){
            throw new CircularQueueException("Circular Queue is full");
        }

        data[end] = item;
        end++;
        end = end % data.length;
        size++;
        return true;
    }

    public int remove() throws CircularQueueException{
        if(isEmpty()){
            throw new CircularQueueException("Queue is Empty!!!");
        }
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;
        return removed;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Circular Queue is Empty!");
            return;
        }
        int i = front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i = i % data.length;
        }while(i!=end);
        System.out.println("END");
    }
}
