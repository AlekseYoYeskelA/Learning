package multithreading;

public class Ex8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Method main begins");
        Thread thread = new Thread(new Worker());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
        System.out.println("Method main ends");
    }
}

class Worker implements Runnable{
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        System.out.println("Work ends");
    }
}
