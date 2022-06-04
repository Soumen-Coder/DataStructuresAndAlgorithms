package StacksAndQueues;

public class DynamicStack extends CustomStack{

    DynamicStack(){
        super();
    }

    DynamicStack(int size){
        super(size);
    }

    @Override
    public int push(int item) throws StackException{
        int[] temp = new int[data.length * 2];

        for(int i=0; i<data.length; i++){
            temp[i] = data[i];
        }

        data = temp;

        return super.push(item);
    }

}
