package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task416 {
    static boolean isEqually(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        List<Integer> list = new ArrayList<>();
        list.add(array[array.length - 1]);
        double sumArray = Arrays.stream(array).sum();   // sum = 22
        double sumList = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            if (sumList + array[i] <= sumArray / 2) {
                list.add(array[i]);
            }
            sumList = list.stream().mapToInt(x -> x.intValue()).sum();
        }
        return sumArray / 2 == sumList;
    }


    static boolean isEqually1(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());

        int sumArray = Arrays.stream(array)
                .mapToInt(num -> num.intValue())
                .sum();

        if (sumArray % 2 != 0) {
            return false;
        }
        if (array[0] == sumArray / 2) {
            return true;
        }

        AtomicInteger sumList = new AtomicInteger(0);
        Arrays.stream(array)
                .filter(num -> sumArray / 2 >= sumList.get() + num)
                .peek(num -> System.out.println("После фильтра num = " + num + " , сумлист =  " + sumList))
                .map(num -> {
                    sumList.addAndGet(num);
                    return num;
                })
                .peek(num -> System.out.println("После мапы num = " + num + " , сумлист =  " + sumList))
                .collect(Collectors.toList());

        return sumArray / 2 == sumList.get();
    }
}

class Task416Test {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 1};
        System.out.println(Task416.isEqually1(array));
    }
}

