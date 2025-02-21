package comparation;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zaur", "Tregulov", 56214);
        Employee emp2 = new Employee(69, "Alexey", "Busarov", 93321);
        Employee emp3 = new Employee(73, "Katya", "Savotchenko", 83219);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting \n" + list);
        list.sort(new SalaryComparator());
        System.out.println("After sorting \n" + list);
    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee anEmp) { //сравнивает текущий объект с другим используя естественный порядок
        if (this.id == anEmp.id) {
            return 0;
        } else if (this.id < anEmp.id) {
            return -1;
        } else {
            return 1;
        }
//        return this.id - anEmp.id; //вариант написания
//        int res = this.name.compareTo(anEmp.name);
//        if (res == 0){
//            res = this.surname.compareTo(anEmp.surname);
//        }
//        return res;
//    }
    }
}

//class IdComparator implements Comparator<Employee> {
//    @Override
//    public int compare(Employee emp1, Employee emp2) { //сравнивает 2 объекта, используя неестественный порядок
//        if (emp1.id == emp2.id) {
//            return 0;
//        } else if (emp1.id < emp2.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }
//}

    class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.name.compareTo(emp2.name);
        }
    }

    class SalaryComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee emp1, Employee emp2) {
            return emp1.salary - emp2.salary;
        }
    }

