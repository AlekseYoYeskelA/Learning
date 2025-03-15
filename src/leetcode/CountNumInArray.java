package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountNumInArray {
    public static int[] countNumLesserThenCurrent(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int count = 0;

            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static int[] countNumLesserThenCurrent1(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        //мапа, где ключ - число, значение - кол-во элементов, меньше текущего
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {
            countMap.putIfAbsent(sorted[i], i);

//            counts.computeIfPresent(nums[i], (k,v) -> v);
//            if (!counts.containsKey(sorted[i])) {
//                counts.put(sorted[i], i);
//            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = countMap.get(nums[i]);
        }
        return result;
    }

    public static int[] countNumLesserThenCurrent2(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        var countMap = IntStream.range(0, sorted.length)
                .boxed()
                .collect(Collectors.toMap(idx -> sorted[idx], idx -> idx, (key, value) -> key));

        return Arrays.stream(nums)
                .map(countMap::get)
                .toArray();
    }

    public static int[] countNumLesserThenCurrent3(int[] nums) {
        return Arrays.stream(nums)
                .map(inner -> (int) Arrays.stream(nums)
                        .filter(num -> inner > num)
                        .count())
                .toArray();
    }
}

class TestCountNumInArray {
    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3}; // [4, 0, 1, 1, 3]
        System.out.println(Arrays.toString(CountNumInArray.countNumLesserThenCurrent(nums)));
        System.out.println(Arrays.toString(CountNumInArray.countNumLesserThenCurrent1(nums)));
        System.out.println(Arrays.toString(CountNumInArray.countNumLesserThenCurrent2(nums)));
        System.out.println(Arrays.toString(CountNumInArray.countNumLesserThenCurrent3(nums)));
    }
}