package StacksAndQueues;

public class QueueFunctionalityTest{

    public static void main(String[] args) throws QueueException {

        CustomQueue queue = new CustomQueue();

        queue.insert(3);
        queue.insert(8);
        queue.insert(15);
        queue.insert(7);
        queue.insert(9);
        queue.insert(40);

        queue.display();

        System.out.println(queue.remove());

        queue.display();
    }


}
