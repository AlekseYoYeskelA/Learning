package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task728 {
    public static boolean isSelfDividing1(int num) {
        int arrayCount = String.valueOf(num).split("").length; //480

        Long counter = Arrays.stream(String.valueOf(num).split(""))
                .map(number -> Integer.valueOf(number))
                .filter(number -> number != 0)
                .filter(number -> num % number == 0)
                .count();

        return counter == arrayCount;
    }

    public static List<Integer> selfDividingNumbers1(int left, int right) {
        return IntStream.range(left, right)
                //.filter(number -> Task728.isSelfDividing1(number))
                .filter(num -> {
                    int arrayCount = String.valueOf(num).split("").length; //480
                    Long counter = Arrays.stream(String.valueOf(num).split(""))
                            .map(number -> Integer.valueOf(number))
                            .filter(number -> number != 0)
                            .filter(number -> num % number == 0)
                            .count();
                    return counter == arrayCount;
                })
                .boxed()
                .collect(Collectors.toList());
    }


    public static boolean isSelfDividing(int num) {
        if (num < 10) {
            return true; // Однозначные числа всегда саморазделяющиеся
        }
        // Дополнительная проверка: если число начинается с нуля, оно не саморазделяющееся
        if (num / 10 == 0) {
            return false;
        }

        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing1(i)) {
                result.add(i);
            }
        }
        return result;
    }
}

class Task728Test {

    public static void main(String[] args) {
        int left = 47;
        int right = 85;
        List<Integer> result = Task728.selfDividingNumbers1(left, right);
        System.out.println("Саморазделяющиеся числа в диапазоне [" + left + ", " + right + "]: " + result);
    }
}
