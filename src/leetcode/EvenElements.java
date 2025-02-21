package leetcode;

import java.util.Arrays;

public class EvenElements {
    public static int elCount(int[] array) {
        return (int) Arrays.stream(array)
                .filter(num -> num % 2 == 0)
                .count();
    }

    public static int elCount1(int[] array) {
        int count = 0;
        for (int num : array) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}

class EvenTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int res = EvenElements.elCount1(array);
        System.out.println(res);
    }
}