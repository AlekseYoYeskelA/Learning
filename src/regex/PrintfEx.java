package regex;

public class PrintfEx {
    static void employeeInfo(Employee emp) {
        System.out.printf("%03d \t %-12s \t %-12s \t %,.1f \n", emp.id, emp.name, emp.surname, emp.salary * (1 + emp.bonusPct));
    }


    public static void main(String[] args) {
        //System.out.printf("string - nujno viravnit po levomu krayu, a double - okruglit do desyatih", "Hello", "3.1415");
        Employee emp1 = new Employee(1, "Alex", "Busarov", 365158, 0.33);
        Employee emp2 = new Employee(15, "Zaur", "Tregulov", 125684, 0.15);
        Employee emp3 = new Employee(562, "Mariya", "Ivanova", 69844, 0.15);
        employeeInfo(emp1);
        employeeInfo(emp2);
        employeeInfo(emp3);

        String newString = String.format("%03d \t %-12s \t %-12s \t %,.1f ", 1, "Alex", "Busarov", 365158* (1+0.33));
        System.out.println(newString);
    }
}

class Employee {
    int id;
    String name;
    String surname;
    int salary;
    double bonusPct;

    public Employee(int id, String name, String surname, int salary, double bonusPct) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.bonusPct = bonusPct;
    }
}
