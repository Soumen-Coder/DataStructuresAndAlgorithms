package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
    static Queue<Integer> queue;

    StackUsingSingleQueue(){
        queue = new LinkedList<>();
    }
    public static void push(int item){

        int size = queue.size();

        queue.add(item);

        for (int i = 0; i < size; i++) {
           int element = queue.remove();
           queue.add(element);
        }
    }

    public static int peek(){
        if (queue.isEmpty())
        {
            //System.out.println("No elements");
            return -1;
        }
        return queue.peek();
    }

    public static int pop(){
        if (queue.isEmpty())
        {
            //System.out.println("No elements");
            return -1;
        }
        return queue.remove();
    }

    public static boolean isEmpty(){
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        StackUsingSingleQueue sq = new StackUsingSingleQueue();
        sq.push(3);
        sq.push(2);
        sq.push(4);
        sq.push(1);
        System.out.println(sq.peek()); //1
        sq.pop();
        System.out.println(sq.peek()); //4
    }
}
