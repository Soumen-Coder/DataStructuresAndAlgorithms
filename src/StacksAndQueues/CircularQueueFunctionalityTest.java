package StacksAndQueues;

public class CircularQueueFunctionalityTest {

    public static void main(String[] args) throws CircularQueueException {

        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.insert(3);
        circularQueue.insert(6);
        circularQueue.insert(5);
        circularQueue.insert(19);
        circularQueue.insert(1);

        circularQueue.display();

        System.out.println(circularQueue.remove());
        circularQueue.insert(133);

        circularQueue.display();




    }
}
