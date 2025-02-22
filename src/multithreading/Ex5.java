package multithreading;

public class Ex5 implements Runnable{
    @Override
    public void run() {
        System.out.println("Method run. Thread name = " + Thread.currentThread());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Ex5());
        thread1.start();
        System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
    }
}
