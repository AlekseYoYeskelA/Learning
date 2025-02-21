package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {
    public static void main(String[] args) {
        Semaphore callBox = new Semaphore(2);
        new Person("Alex", callBox);
        new Person("Zaur", callBox);
        new Person("George", callBox);
        new Person("Ksenia", callBox);
        new Person("Katya", callBox);
    }
}

class Person extends Thread{
    String name;
    private Semaphore callBox;

    public Person(String name, Semaphore callBox) {
        this.name = name;
        this.callBox = callBox;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " wait...");
        try {
            callBox.acquire();
            System.out.println(name + " use callbox");
            sleep(2000);
            System.out.println(name + " finished call");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            callBox.release();
        }
    }
}