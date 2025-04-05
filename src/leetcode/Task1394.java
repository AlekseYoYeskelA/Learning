package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.chrono.JapaneseEra.values;

public class Task1394 {
    public static List<Integer> findLucky(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)))
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .toList();
    }
}

class Task1394Test {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
        System.out.println(Task1394.findLucky(nums));
    }
}

