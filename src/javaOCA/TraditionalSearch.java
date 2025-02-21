package javaOCA;
import java.util.ArrayList;
import java.util.List;

public class TraditionalSearch {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<Animal>(); // list of animals
        animals.add(new Animal("fish", false, true));
        animals.add(new Animal("kangaroo", true, false));
        animals.add(new Animal("rabbit", true, false));
        animals.add(new Animal("turtle", false, true));

        //print(animals, new CheckIfHopper()); // pass class that does check

        print(animals, a -> a.canHop());
        //где a - параметр, -> - разделитель параметров и тела метода, a.canHop() - тело метода
        // () можно опустить только в том случае, если имеется один параметр и его тип не указан явно

        //более подробное написание
        print(animals, (Animal a) -> {
            return a.canHop();
        });

        print(animals, a -> a.canSwim());
        print(animals, a -> !a.canSwim());
    }

    private static void print(List<Animal> animals, CheckTrait checker) {
        for (Animal animal : animals) {
            if (checker.test(animal)) // the general check
                System.out.print(animal + " ");
        }
        System.out.println();
    }
}


//        print(() -> true); // 0 parameters
//        print(a -> a.startsWith("test")); // 1 parameter
//        print((String a) -> a.startsWith("test")); // 1 parameter
//        print((a, b) -> a.startsWith("test")); // 2 parameters
//        print((String a, String b) -> a.startsWith("test")); // 2 parameters

//        print(a, b -> a.startsWith("test")); // DOES NOT COMPILE
//        print(a -> { a.startsWith("test"); }); // DOES NOT COMPILE
//        print(a -> { return a.startsWith("test") }); // DOES NOT COMPILE


//    Есть еще одна проблема, с которой вы можете столкнуться при работе с лямбдами. Мы определяем список аргументов
//    в наших лямбда-выражениях. Поскольку Java не позволяет нам повторно объявлять локальную переменную, то
//    следующее является проблемой:
//            (a, b) -> { int a = 0; return 5;} // НЕ КОМПИЛИРУЕТСЯ
//    Мы попытались повторно объявить a, что запрещено. В отличие от этого, следующая строка является нормальной
//    поскольку в ней используется другое имя переменной:
//            (a, b) -> { int c = 0; return 5;}




