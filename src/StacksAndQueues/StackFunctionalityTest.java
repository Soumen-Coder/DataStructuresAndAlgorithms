package StacksAndQueues;

public class StackFunctionalityTest {

    public static void main(String[] args) throws StackException {
        CustomStack stack = new DynamicStack(5);
        stack.push(23);
        stack.push(34);
        stack.push(5);
        stack.push(18);
        stack.push(20);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }

}
