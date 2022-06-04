package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StacksWithQueues {

    static Queue<Integer> queueOne;
    static Queue<Integer> queueTwo;
    static int size;

    StacksWithQueues(){
        queueOne = new LinkedList<>();
        queueTwo = new LinkedList<>();
        this.size = 0;
    }

    public static void push(int item){
        size++;
        //Push the values to Q2
        //Push values from Q1 to Q2, element by element
        //Swap Q2 and Q1, moving values from Q2 to Q1 in the same order
        queueTwo.add(item);

        while(!queueOne.isEmpty()){
            queueTwo.add(queueOne.peek());
            queueOne.remove();
        }

        // swap the contents of two queues, Q2 and Q1
        Queue<Integer> q = queueOne;
        queueOne = queueTwo;
        queueTwo = q;
    }

    public static int peek(){
        return queueOne.peek();
    }

    public static int pop(){
        return queueOne.remove();
    }

    public boolean isEmpty(){
       return queueOne.isEmpty() && queueTwo.isEmpty();
    }

    public static void main(String[] args) {
        StacksWithQueues sq = new StacksWithQueues();
        sq.push(3);
        sq.push(4);
        sq.push(2);
        sq.push(1);
        System.out.println(sq.peek()); //1
        sq.pop();
        System.out.println(sq.peek()); //2
    }

}
