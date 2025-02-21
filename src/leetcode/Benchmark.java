package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Benchmark {
    public static final String EMPTY_STRING = "empty";

    public static String firstLetter(String[] strs) {
        char ch = strs[0].charAt(0);
        boolean isNotSame = Arrays.stream(strs)
                .anyMatch(word -> ch != word.charAt(0));

        if (isNotSame) {
            return EMPTY_STRING;
        }
        return "Done";
    }

    public static String firstLetter1(String[] strs) {
        char ch = strs[0].charAt(0);
        return Arrays.stream(strs)
                .filter(word -> ch != word.charAt(0))
                .map(word -> EMPTY_STRING)
                .findFirst()
                .orElse("Done");
    }


    public static String firstLetter2(String[] strs) {
        char ch = strs[0].charAt(0);
        long count = Arrays.stream(strs)
                .filter(word -> ch == word.charAt(0))
                .count();

        if (count != strs.length) {
            return EMPTY_STRING;
        }
        return "Done";
    }


    public static void main(String[] args) {
        String[] strs = IntStream.range(10000000, 20000000)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        strs[3] = "ABC";
        //System.out.println(strs);

        long startTime1 = System.nanoTime();
        String res = firstLetter(strs);
        System.out.println("Время работы метода anyMatch = " + (System.nanoTime() - startTime1) + " нс " + res);

        long startTime2 = System.nanoTime();
        String res1 = firstLetter1(strs);
        System.out.println("Время работы метода findFirst = " + (System.nanoTime() - startTime2) + " нс " + res1);

        long startTime3 = System.nanoTime();
        String res2 = firstLetter2(strs);
        System.out.println("Время работы метода count = " + (System.nanoTime() - startTime3) + " нс " + res2);
    }
}
