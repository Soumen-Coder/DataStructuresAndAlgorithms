package StacksAndQueues;

public class CustomStack {

    protected int[] data; // stack is nothing but an array
    private int size;
    private int ptr = -1;

    private static final int DEFAULT_SIZE = 10;

    CustomStack(){
        this(DEFAULT_SIZE);
    }

    CustomStack(int size){
        data = new int[size];
        this.size = size;
    }

    public boolean isEmpty(){
        return ptr == -1; // pointer is at the starting of the array
    }

    public boolean isFull(){
        return ptr == data.length - 1;
    }

    public int push(int item) throws StackException{
        if(isFull()){
            throw new StackException("Cannot add when Stack is full");
        }
        ptr++;
        data[ptr] = item;
        return item;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Cannot remove when Stack is empty");
        }
        int item = data[ptr];
        ptr--;
        return item;
        //return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            System.out.println("Stack is Empty, hence returning -1");
            return -1;
        }
        return data[ptr];
    }


}
