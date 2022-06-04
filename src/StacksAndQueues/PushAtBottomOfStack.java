package StacksAndQueues;

import java.util.Stack;

public class PushAtBottomOfStack {
    //Have to push 4 at the bottom of the stack, doing with the help of recursion

    public static void main(String[] args) {
        int data = 4;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        pushAtBottom(data, stack); // push 4 at the bottom, stack now consists of 3 2 1

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    private static void pushAtBottom(int data, Stack<Integer> stack) {
        if(stack.isEmpty()){
            stack.push(data); // As soon as stack becomes empty, push 4 to stack
            return; // return
        }

        int element = stack.pop();
        pushAtBottom(data, stack);
        stack.push(element); // start pushing the popped elements
    }

}
