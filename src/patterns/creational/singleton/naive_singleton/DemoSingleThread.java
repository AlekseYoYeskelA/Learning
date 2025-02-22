package patterns.creational.singleton.naive_singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        System.out.println("If you see same value, then singleton was reused (yay!)" + "\n" +
                "If you see different value, then 2 singletons were created (booo!)" + "\n\n" +
                "RESULT:");

        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }
}
