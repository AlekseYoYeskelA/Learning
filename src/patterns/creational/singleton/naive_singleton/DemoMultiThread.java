package patterns.creational.singleton.naive_singleton;

public class DemoMultiThread {
    public static void main(String[] args) {
        System.out.println("If you see same value, then singleton was reused (yay!)" + "\n" +
                "If you see different value, then 2 singletons were created (booo!)" + "\n\n" +
                "RESULT:");

        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
