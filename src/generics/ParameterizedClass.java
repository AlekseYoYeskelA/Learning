package generics;

public class ParameterizedClass {
    public static void main(String[] args) {
//        Info<String> info1 = new Info<>("privet");
//        System.out.println(info1);
//        String s = info1.getValue();

        Info<Integer>info2 = new Info<>(314);
        System.out.println(info2);
        Integer i1 = info2.getValue();

        Info<Double>info3 = new Info<>(3.14);
        System.out.println(info3);
        Integer i2 = info2.getValue();
    }
}


class Info<T extends Number> { //сначала указывается класс, потом интерфейсы
    private T value; //не может быть static

    public Info(T value) {
        this.value = value;
    }

    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}
    interface I1{}
    interface I2{}


