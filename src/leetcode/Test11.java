package leetcode;

import java.util.Arrays;

public class Test11 {
    public static String[] addClient(String[] array) {
        String client = "Client: ";
        for (int i = 0; i < array.length; i++) {
            array[i] = client + array[i];
        }
        return array;
    }

    public static String[] addClient1(String[] array) {
        return Arrays.stream(array)
                .map(el -> "Client: " + el)
                .toArray(String[]::new);
    }


    public static void main(String[] args) {
        String[] surname = {"Ivanov", "Petrov", "Busarov"};
        System.out.println(Arrays.toString(addClient1(surname)));
    }
}
