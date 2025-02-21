package multithreading;

public class VolatileEx extends Thread {
    // Переменные volatile хранятся не в cash, а в main memory
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished. counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileEx volatileEx = new VolatileEx();
        volatileEx.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up!");
        volatileEx.b = false;
        volatileEx.join();
        System.out.println("End of programm!");
    }
}
