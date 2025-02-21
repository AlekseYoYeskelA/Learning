package patterns.creational.singleton.naive_singleton;

public final class Singleton {
    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        //этот код имитирует медленную инициализацию
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}

