package stream_api;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7.0);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

//        Student min = students.stream()
//                .min((x, y) -> x.getAge() - y.getAge())
//                .get();
//        System.out.println(min);
//
//        Student max = students.stream()
//                .max((x, y) -> x.getAge() - y.getAge())
//                .get();
//        System.out.println(max + "\n_______________\n");


//        students.stream()
//                .filter(st -> st.getAge() > 20)
//                .forEach(System.out::println);
//        System.out.println("\n_______________\n");
//
//        students.stream()
//                .filter(st -> st.getAge() > 20)
//                .limit(2)
//                .forEach(System.out::println);
//        System.out.println("\n_______________\n");
//
//        students.stream()
//                .filter(st -> st.getAge() > 20)
//                .skip(2)
//                .forEach(System.out::println);

//        List<Integer> courses = students.stream()
//                .mapToInt(st -> st.getCourse())
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(courses);
//
//        List<Double> grades = students.stream()
//                .mapToDouble(st -> st.getAvgGrade())
//                .boxed()
//                .collect(Collectors.toList());
//        System.out.println(grades);

        int sum = students.stream()
                .mapToInt(st -> st.getCourse())
                .sum();
        System.out.println(sum);

        double average = students.stream()
                .mapToInt(st -> st.getCourse())
                .average().getAsDouble();
        System.out.println(average);

        int minCourse = students.stream()
                .mapToInt(st -> st.getCourse())
                .min().getAsInt();
        System.out.println(minCourse);

        int maxCourse = students.stream()
                .mapToInt(st -> st.getCourse())
                .max().getAsInt();
        System.out.println(maxCourse);

    }
}
