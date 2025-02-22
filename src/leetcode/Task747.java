package leetcode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Task747 {
    public static int dominantIndex(int[] nums) {
        int maxValIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[maxValIdx] < nums[i]) {
                maxValIdx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (maxValIdx != i && nums[maxValIdx] / 2 >= nums[i]) {
                return maxValIdx;
            }
        }
        return -1;
    }

    public static int dominantIndex1(int[] nums) {
        AtomicInteger idx = new AtomicInteger(Integer.MIN_VALUE);

        int maxVal = Arrays.stream(nums)
                .max()
                .getAsInt();

        long count = Arrays.stream(nums)
                .filter(num -> num <= maxVal/2)
                .count();

        if(count == nums.length - 1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == maxVal) {
                    return i;
                }
            }
        }
        return -1;
    }
}

class Test747 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println(Task747.dominantIndex(nums));
    }
}