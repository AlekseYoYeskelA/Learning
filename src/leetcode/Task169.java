package leetcode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task169 {
    public static int majorityElement(int[] nums) {
        var majority = nums.length / 2;

        for (int num : nums) {
            var count = 0;
            for (int el : nums) {
                if (el == num) {
                    count++;
                }
            }

            if (count > majority) {
                return num;
            }
        }
        throw new NoSuchElementException("No value present");
    }

    public static int majorityElement2(int[] nums) {
        var majority = nums.length / 2;

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > majority)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    public static int majorityElement3(int[] nums) {
        var majority = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();


        for (int num : nums) {
            map.compute(num, (key, value) -> Objects.isNull(value) ? 1 : value + 1);

//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }
        }

        System.out.println(map);

        var entries = map.entrySet();

        for (var entry : entries) {
            if (entry.getValue() > majority) {
                return entry.getKey();
            }
        }
        throw new NoSuchElementException("No value present");
    }


    public static int majorityElement4(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}


class Test169 {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);

        int[] array = IntStream.iterate(1, i -> i + 1)
                .limit(50)
                .toArray();
        System.out.println(Arrays.toString(array));

//      int last =  Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
//                .limit(10)
//                .map(y -> y[0])
//                .mapToInt(Integer::intValue)
//                .sum();
//        System.out.println(last);

        int[] nums = {0, 1, 2, 2, 1, 2, 2};
//        System.out.println(Task169.majorityElement(nums));
//        System.out.println(Task169.majorityElement2(nums));
//        System.out.println(Task169.majorityElement3(nums));
    }
}
