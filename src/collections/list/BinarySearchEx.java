package collections.list;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BinarySearchEx {
    public static void main(String[] args) {
//        int[] nums = {-3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19};
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        Collections.sort(list);
//        int index1 = Collections.binarySearch(list, 12);
//        System.out.println(index1);
//    }

        Employee emp1 = new Employee(15, "Zaur", 12345);
        Employee emp2 = new Employee(250, "Ivan", 6542);
        Employee emp3 = new Employee(123, "Petr", 6542);
        Employee emp4 = new Employee(15, "Mariya", 5678);
        Employee emp5 = new Employee(182, "Kolya", 125);
        Employee emp6 = new Employee(15, "Sasha", 9874);
        Employee emp7 = new Employee(15, "Elena", 1579);

        List<Employee> list1 = new ArrayList<>();
        list1.add(emp1);
        list1.add(emp2);
        list1.add(emp3);
        list1.add(emp4);
        list1.add(emp5);
        list1.add(emp6);
        list1.add(emp7);
        System.out.println(list1);
        Collections.sort(list1);
        System.out.println(list1);
        int index2 = Collections.binarySearch(list1, new Employee(123, "Petr", 6542));
        System.out.println(index2);
    }
}

class Employee implements Comparable<Employee>{
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        int result = this.id - employee.id;
        if (result == 0) {
            result = this.name.compareTo(employee.name);
        }
        return result;
    }
}