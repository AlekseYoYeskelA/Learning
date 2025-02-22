package reflection;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        Employee employee = new Employee(10, "Alex", "IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");
        field.setAccessible(true);
        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee, 1500);
        System.out.println(employee);
    }
}
