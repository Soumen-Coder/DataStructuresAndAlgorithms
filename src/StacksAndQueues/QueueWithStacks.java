package StacksAndQueues;

import java.util.Stack;

public class QueueWithStacks {
    static Stack<Integer> stackOne;
    static Stack<Integer> stackTwo;

    QueueWithStacks(){
        stackOne = new Stack<>();
        stackTwo = new Stack<>();
    }

    public static void push(int item) {
        //s1 to s2
        while(!stackOne.isEmpty()){
            stackTwo.push(stackOne.peek());
            stackOne.pop();
        }

        //push(x) to s1
        stackOne.push(item);

        //s2 to s1
        while (!stackTwo.isEmpty()){
            stackOne.push(stackTwo.peek());
            stackTwo.pop();
        }
    }

    public static int peek(){
        return stackOne.peek();
    }

    public static int pop(){
       int element = stackOne.pop();
       return element;
    }

    public static void main(String[] args) {
        QueueWithStacks qs = new QueueWithStacks();
        qs.push(4);
        qs.push(3);
        qs.push(2);
        qs.push(5);
        System.out.println(qs.peek()); //4
        System.out.println(qs.pop()); //4
        qs.peek(); //3
    }
}
