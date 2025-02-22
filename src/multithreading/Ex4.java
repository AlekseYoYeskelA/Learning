package multithreading;

public class Ex4 {
    public static void main(String[] args) {
        MyThread5 myThread5 = new MyThread5();
        myThread5.setName("V_(p==r)otok");
        myThread5.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Name of tread: " + myThread5.getName() + " Priority of thread: " + myThread5.getPriority());

    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello");
    }
}
