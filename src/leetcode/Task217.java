package leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet())
                .size() != nums.length;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums)
                .anyMatch(el -> !set.add(el));
    }

    public boolean containsDuplicate3(int[] nums) {
        return Arrays.stream(nums)
                .distinct()
                .count() != nums.length;
    }
}

class Test217 {
    public static void main(String[] args) {
        Task217 t = new Task217();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(t.containsDuplicate1(nums));
    }
}
