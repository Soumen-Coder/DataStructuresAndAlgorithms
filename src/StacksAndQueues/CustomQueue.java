package StacksAndQueues;

// insert
// 3 <- 8 <- 7 <- 16 <- 15 <- END
// remove 3
// display : 8 <- 7 <- 16 <- 15 <- END


public class CustomQueue {
    
    protected static int[] data;
    private int size;
    
    private static final int DEFAULT_SIZE = 10;
    
    static int rear = -1;
    
    CustomQueue(){
        this(DEFAULT_SIZE);
    }
    
    CustomQueue(int size){
        data = new int[size];
        this.size = size;
    }
    
    public boolean isFull(){
        return rear == data.length-1;
    }
    
    public static boolean isEmpty(){
        return rear == -1;
    }

    //we work with rear in queue, no concept of front here
    //called as enqueue as well
    //O(1)
    public boolean insert(int item) throws QueueException{
        if(isFull()){
            throw new QueueException("Queue is Full!!!");
        }
        data[rear++] = item;
        return true;
    }

    //remove first element
    //move the elements after the removed elements to manage the empty space
    //Time complexity with arrays - O(n) - Hence we don't implement queue with arrays
    public int remove() throws QueueException{
        if(isEmpty()){
            throw new QueueException("Queue is Empty, Elements cannot be removed!");
        }
        int front = data[0];
        for (int i = 0; i < rear; i++) {
            data[i] = data[i+1];
        }
        rear--;
        return front;
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }

        return data[0];
    }
    
    public void display(){
        for (int i = 0; i < rear; i++) {
            System.out.print(data[i] + " <- ");
        }
        System.out.println("END");
    }
    
    
}
