package stream_api;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test1 {
    public static void main(String[] args) {
        int[] array = {1, 3, 6, 5, 7, 9, 4, 12, 2, 8};
        int result = Arrays.stream(array)
                .filter(el -> el % 2 == 1)
                .map(el -> { if (el % 3 == 0){el=el/3;} return el;})
                .reduce((a, el) -> a+el).getAsInt();
        System.out.println(result);

    }
}