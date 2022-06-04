package StacksAndQueues;

import java.util.Stack;

public class QueueWithStacksAnotherApproach {

    static Stack<Integer> stackInp;
    static Stack<Integer> stackOut;

    QueueWithStacksAnotherApproach(){
        stackInp = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        //push to input stack
        stackInp.push(x);

    }

    public int pop() {
        // if output not empty, return output.pop()
        //else
        //push input to output and return output.pop()
        if(!stackOut.isEmpty())
            return stackOut.pop();
        else{
            while(!stackInp.empty()){
                stackOut.push(stackInp.peek());
                stackInp.pop();
            }
        }
        return stackOut.pop();
    }

    public int peek() {
        // if output not empty, return output.peek()
        //else
        //push input to output and return output.peek()
        if(!stackOut.isEmpty())
            return stackOut.peek();
        else{
            while(!stackInp.empty()){
                stackOut.push(stackInp.peek());
                stackInp.pop();
            }
        }
        return stackOut.peek();
    }

    public boolean empty() {
        return stackInp.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args) {
        QueueWithStacksAnotherApproach qs = new QueueWithStacksAnotherApproach();
        qs.push(2);
        qs.push(5);
        qs.push(3);
        System.out.println(qs.peek()); // 2
        qs.pop();
        qs.push(6);
        qs.pop();
        qs.pop();
        System.out.println(qs.peek()); // 6
        System.out.println(qs.empty()); // false
    }
}
