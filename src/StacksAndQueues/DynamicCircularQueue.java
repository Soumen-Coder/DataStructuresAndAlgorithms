package StacksAndQueues;

public class DynamicCircularQueue extends CircularQueue{

    @Override
    public boolean insert(int item) throws CircularQueueException{

        if(this.isFull()){
            int[] temp = new int[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }

            data = temp;
        }
        front = 0;
        end = data.length;
        size++;
        return super.insert(item);
    }

}
