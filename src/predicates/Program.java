package predicates;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Сергей", 38));
        list.add(new Person("Даша", 7));
        list.add(new Person("Маша", 3));
        list.add(new Person("Саша", 6));
        list.add(new Person("Анна", 19));

//        for (Person person : list){
//            System.out.println(person);
//        }

        int summa = 0;
        int adult = 0;
        for (Person pers : list) {
            if (pers.getAge() >= 18) {
                summa += pers.getAge();
                adult++;
            }
            double averageAge = (double) summa / adult;
            System.out.println(averageAge);


            Double averageAge2 = list.stream()
                    .filter(p -> p.getAge() >= 18) //фильтрация объектов по условию
                    .mapToInt(Person::getAge)// преобразование набора объектов в набор int
                    .average()// расчет среднеарифметического
                    .getAsDouble(); //возвращает значения типа double
            System.out.println(averageAge2);


            list.stream()
                    .filter(person -> person.getAge() >= 18)
                    .sorted((person1, person2) -> person1.getName().compareTo(person2.getName()))
                    .map(person -> person.getName())
                    .forEach(System.out::println);
            //.forEach(person -> System.out.println(person))
        }
    }
}