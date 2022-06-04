package multithreading;

public class Multithreaded {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            MyClass myClass = new MyClass(i);
            Thread myThread = new Thread(myClass);
            myThread.start();
            myThread.isAlive();
        }
        //throw new RuntimeException(); - even after main thread throws exception here, the child thread continues to work

    }
}

//implements Runnable has an upper hand because once Thread extended, cannot extend other class because Java doesn't allow multiple inheritance
//with implements you can extend and implement multiple interfaces as well
class MyClass implements Runnable{

    private int threadNumber;

    MyClass(int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 5; i++) {

            System.out.println(i + " from Thread "+threadNumber);
            if(threadNumber==3){
                throw new RuntimeException(); // even one child thread throws exception. other continues to work
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Thread.join(1000); // Thread.join allows a thread to complete a task or die before the next starts, kind of suppressing the multithreading behaviour
        }

    }
}