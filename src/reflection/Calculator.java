package reflection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void sum(int a, int b) {
        int result = a + b;
        System.out.println("Сумма " + a + " и " + b + " = " + result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println("Разница " + a + " и " + b + " = " + result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println("Произведение " + a + " и " + b + " = " + result);
    }

    void division(int a, int b) {
        int result = a / b;
        System.out.println("Частное " + a + " и " + b + " = " + result);
    }
}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("testcl.txt"))) {
            String methodName = reader.readLine();
            String firstArgument = reader.readLine();
            String secondArgument = reader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;

            Method[] methods = cl.getDeclaredMethods();
            for (Method myMethod : methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }
            method.invoke(calculator, Integer.parseInt(firstArgument), Integer.parseInt(secondArgument));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}