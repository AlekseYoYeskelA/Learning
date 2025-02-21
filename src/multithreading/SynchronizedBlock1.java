package multithreading;

public class SynchronizedBlock1 {
    public static void main(String[] args) {
        MyRunnableImp2 runnable = new MyRunnableImp2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Counter2 {
    static int count = 0;
}


class MyRunnableImp2 implements Runnable {
    private void doWork2(){
        System.out.println("BLYAAAAAA!!!");
    }



    private void doWork1() {
        doWork2();
        // при использовании synchronized блока, явно указываем на объект, монитор которого будет использован для синхронизации
        synchronized (this) {
            Counter2.count++;
            System.out.println(Counter2.count);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}
