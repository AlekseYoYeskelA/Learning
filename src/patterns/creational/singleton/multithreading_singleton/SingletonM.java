package patterns.creational.singleton.multithreading_singleton;

public final class SingletonM {
    //поле обязательно должно быть объявлено volatile, чтобы двойная проверка блокировки сработала как надо
    private static volatile SingletonM instance;
    public String value;

    public SingletonM(String value) {
        this.value = value;
    }

    //Double-Checked Locking (блокировка с двойной проверкой) - применяется, чтобы предотвратить создание нескольких
    //объектов-одиночек, если метод будет вызван из нескольких потоков одновременно
    public static SingletonM getInstance(String value) {
        SingletonM result = instance;
        if (result != null) {
            return result;
        }
        synchronized (SingletonM.class) {
            if (instance == null) {
                instance = new SingletonM(value);
            }
            return instance;
        }
    }
}
